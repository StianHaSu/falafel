package dto.internal

import java.util.UUID

data class ProductDto(
    val id: UUID,
    val name: String,
    val price: Double,
    val imageUrl: String?,
    val description: String?,
)