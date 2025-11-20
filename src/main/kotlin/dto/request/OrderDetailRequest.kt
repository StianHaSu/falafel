package dto.request

import java.util.UUID

data class OrderDetailRequest(
    val productId: UUID,
    val quantity: Int,
)