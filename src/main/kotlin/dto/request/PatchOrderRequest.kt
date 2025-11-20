package dto.request

import OrderStatus
import PaymentStatus

data class PatchOrderRequest(
    val paymentStatus: PaymentStatus?,
    val orderStatus: OrderStatus?
)
