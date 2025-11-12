package dao.repository

import dao.adapter.order.OrderAdapter
import dao.entity.Order
import dto.OrderDto
import dto.OrderRequest
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
}