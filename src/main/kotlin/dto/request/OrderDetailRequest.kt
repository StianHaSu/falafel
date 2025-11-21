package dto.request

import jakarta.validation.constraints.Min
import java.util.UUID

data class OrderDetailRequest(
    val productId: UUID,
    @param:Min(1) val quantity: Int,
)