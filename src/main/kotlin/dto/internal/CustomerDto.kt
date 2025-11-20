package dto.internal

import java.util.UUID

data class CustomerDto(
    val customerId: UUID,
    val nickname: String,
    val phoneNumber: String,
)