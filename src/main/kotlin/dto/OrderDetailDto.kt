package dto

import java.util.UUID

data class OrderDetailDto(
    val productId: UUID,
    val productName: String,
    val orderId: UUID,
    val quantity: Int,
)