package dao.adapter.order

import dao.entity.Order
import dto.internal.CustomerDto
import dto.internal.OrderDto
import dto.request.OrderRequest
import dto.toOrderDetailDto
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
            order.created,
        order.details.map { it.toOrderDetailDto() }
        )
    }

    override fun fromOrderRequest(orderRequest: OrderRequest, id: UUID, customerId: UUID): Order {
        val order = Order()

        order.id = id
        order.customerId = customerId
        order.paymentStatus = PaymentStatus.PENDING
        order.orderStatus = OrderStatus.PENDING
        order.created = Instant.now()
        order.updated = Instant.now()

        return order
    }
}