package dto.request

import OrderStatus
import PaymentStatus
import jakarta.ws.rs.QueryParam


data class OrderFilter(
    @field:QueryParam("orderStatus") var orderStatus: OrderStatus? = null,
    @field:QueryParam("paymentStatus") var paymentStatus: PaymentStatus? = null
)
