package dto

data class OrderRequest(
    val order: String,
    val customer: CustomerDto
)
