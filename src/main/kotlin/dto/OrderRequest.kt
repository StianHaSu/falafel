package dto

data class OrderRequest(
    val customer: CustomerRequest,
    val orderDetails: List<OrderDetailRequest>
)
