package dto.response

import OrderStatus
import PaymentStatus
import dto.internal.CustomerDto
import dto.internal.OrderDetailDto
import java.time.Instant
import java.util.UUID

data class OrderResponse (
    val id: UUID,
    val customer: CustomerDto,
    val paymentStatus: PaymentStatus,
    val orderStatus: OrderStatus,
    val created: Instant,
    val totalPrice: Double,
    val details: List<OrderDetailDto>
)
