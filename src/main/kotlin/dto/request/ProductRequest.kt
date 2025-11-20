package dto.request

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank

data class ProductRequest(
    @param:NotBlank
    val productName: String,
    val productDescription: String,
    @param:Min(0)
    val productPrice: Double,
    val productImageUrl: String?
)