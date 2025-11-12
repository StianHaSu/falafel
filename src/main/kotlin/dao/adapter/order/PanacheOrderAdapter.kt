package dao.adapter.order

import dao.entity.Order
import dto.CustomerDto
import dto.OrderDto
import dto.OrderRequest
import jakarta.enterprise.context.ApplicationScoped
import java.time.Instant
import java.util.UUID

@ApplicationScoped
class PanacheOrderAdapter : OrderAdapter<Order>() {
    override fun toOrderDto(order: Order): OrderDto {
        return OrderDto(
            order.id,
            CustomerDto(order.customer.id, order.customer.nickname, order.customer.phoneNumber),
            order.paymentStatus,
            order.orderStatus,
            order.created
        )
    }

    override fun fromOrderRequest(dto: OrderRequest): Order {
        val order = Order()

        order.id = UUID.randomUUID()
        order.paymentStatus = PaymentStatus.PENDING
        order.orderStatus = OrderStatus.PENDING
        order.created = Instant.now()
        order.updated = Instant.now()

        return order
    }
}