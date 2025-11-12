package dto

data class ProductRequest(
    val productName: String,
    val productDescription: String,
    val productPrice: Double,
    val productImageUrl: String?
)
