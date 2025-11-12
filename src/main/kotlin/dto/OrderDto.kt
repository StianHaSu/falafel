package dto

import OrderStatus
import PaymentStatus
import java.time.Instant
import java.util.UUID

data class OrderDto(
    val id: UUID,
    val customer: CustomerDto,
    val paymentStatus: PaymentStatus,
    val orderStatus: OrderStatus,
    val created: Instant
)
