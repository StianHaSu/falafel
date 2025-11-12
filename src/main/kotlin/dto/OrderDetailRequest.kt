package dto

import java.util.UUID

data class OrderDetailRequest(
    val productId: UUID,
    val quantity: Int,
)
