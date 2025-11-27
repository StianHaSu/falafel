package dto.request

import Category
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank

data class ProductRequest(
    @NotBlank
    val productName: String,
    val productDescription: String,
    @field:Min(0)
    val productPrice: Double,
    val productImageUrl: String?,
    val categories: List<Category>?,
)