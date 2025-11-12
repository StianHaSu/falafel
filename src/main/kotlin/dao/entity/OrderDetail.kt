package dao.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.IdClass
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "order_details")
@IdClass(OrderDetailKey::class)
class OrderDetail {
    @Id
    @Column(name = "product_id")
    lateinit var productId: UUID

    @Id
    @Column(name = "order_id")
    lateinit var orderId: UUID

    var quantity: Int = 0

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false, insertable = false, updatable = false)
    lateinit var order: Order

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false, insertable = false, updatable = false)
    lateinit var product: Product
}