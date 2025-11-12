package dao.entity

import OrderStatus
import PaymentStatus
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.time.Instant
import java.util.UUID

@Entity
class Order {
    @Id
    lateinit var id: UUID

    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    lateinit var customer: Customer

    @Column(name = "payment_status")
    lateinit var paymentStatus: PaymentStatus

    @Column(name = "order_status")
    lateinit var orderStatus: OrderStatus

    lateinit var created: Instant

    lateinit var updated: Instant
}