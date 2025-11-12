package dao.entity

import jakarta.persistence.Id
import java.io.Serializable
import java.util.UUID

class OrderDetailKey: Serializable {
    @Id
    lateinit var productId: UUID

    @Id
    lateinit var orderId: UUID
}