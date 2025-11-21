package dto.request

import OrderStatus
import PaymentStatus
import jakarta.ws.rs.QueryParam


data class OrderFilter(
    @field:QueryParam("orderStatus") val orderStatus: OrderStatus?,
    @field:QueryParam("paymentStatus") val paymentStatus: PaymentStatus?
)
