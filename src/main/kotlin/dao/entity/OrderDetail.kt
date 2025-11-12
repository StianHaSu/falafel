package dao.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.IdClass
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.util.UUID

@Entity
@IdClass(OrderDetailKey::class)
class OrderDetail {
    @Id
    lateinit var productId: UUID

    @Id
    lateinit var orderId: UUID

    lateinit var quantity: Integer

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    lateinit var product: Product

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    lateinit var order: Order
}