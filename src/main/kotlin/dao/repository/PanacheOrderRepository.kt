package dao.repository

import OrderStatus
import PaymentStatus
import dao.adapter.order.OrderAdapter
import dao.entity.Order
import dto.internal.OrderDto
import dto.request.OrderFilter
import dto.request.OrderRequest
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import java.util.UUID

@ApplicationScoped
class PanacheOrderRepository(private val adapter: OrderAdapter<Order>) : PanacheRepository<Order>, OrderRepository {

    override fun insertOrder(order: OrderRequest, id: UUID, customerId: UUID) {
        persist(adapter.fromOrderRequest(order, id, customerId))
    }

    override fun getOrderById(orderId: UUID): OrderDto? {
        return find(
            "select distinct o from orders o " +
                    "left join fetch o.details " +
                    "where o.id = ?1",
            orderId
        ).firstResult()?.let { adapter.toOrderDto(it) }
    }

    override fun getOrders(filter: OrderFilter): List<OrderDto> {
        return StringBuilder("select distinct o from orders o left join fetch o.details")
            .let { query -> applyFilterToQuery(query, filter)
                .let { params ->
                    list(query.toString(), params).map { adapter.toOrderDto(it) }
                }

            }
    }

    override fun setOrderStatus(id: UUID, orderStatus: OrderStatus) {
        update("orderStatus = ?1 where id = ?2", orderStatus, id)
    }

    override fun setPaymentStatus(id: UUID, paymentStatus: PaymentStatus) {
        update("paymentStatus = ?1 where id = ?2", paymentStatus, id)
    }

    private fun applyFilterToQuery(query: StringBuilder, filter: OrderFilter): Map<String, Any> {
        return getMapOfStatements(filter)
            .takeIf { it.isNotEmpty() }
            ?.also { statements -> applyStatements(query, statements.keys.toList()) }
            .orEmpty()
    }

    private fun applyStatements(query: StringBuilder, statementKeys: List<String>) {
        query.append(" where o." + statementKeys[0] + " = :" + statementKeys[0])
        repeat(statementKeys.size - 1) {
            query.append(" and o." + statementKeys[it + 1] + " = :" + statementKeys[it + 1])
        }
    }

    private fun getMapOfStatements(filter: OrderFilter): Map<String, Any> =
        mutableMapOf<String, Any>()
            .also { statements ->
                filter.orderStatus?.let { orderStatus -> statements["orderStatus"] = orderStatus }
                filter.paymentStatus?.let { paymentStatus -> statements["paymentStatus"] = paymentStatus }
            }
}