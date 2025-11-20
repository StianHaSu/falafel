package dto.request

data class OrderRequest(
    val customer: CustomerRequest,
    val orderDetails: List<OrderDetailRequest>
)