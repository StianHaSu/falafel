package dao.repository

import OrderStatus
import PaymentStatus
import dao.adapter.order.OrderAdapter
import dao.entity.Order
import dto.internal.OrderDto
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

    override fun getAllOrders(): List<OrderDto> {
        return list("select distinct o from orders o " +
                "left join fetch o.details ").map { adapter.toOrderDto(it) }
    }

    override fun setOrderStatus(id: UUID, orderStatus: OrderStatus) {
        update("orderStatus = ?1 where id = ?2", orderStatus, id)
    }

    override fun setPaymentStatus(id: UUID, paymentStatus: PaymentStatus) {
        update("paymentStatus = ?1 where id = ?2", paymentStatus, id)
    }
}