package dao.entity

import jakarta.persistence.Column
import jakarta.persistence.Id
import java.io.Serializable
import java.util.UUID

class OrderDetailKey: Serializable {
    @Id
    @Column(name = "product_id")
    lateinit var productId: UUID

    @Id
    @Column(name = "order_id")
    lateinit var orderId: UUID
}