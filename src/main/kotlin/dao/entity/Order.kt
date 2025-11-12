package dao.entity

import OrderStatus
import PaymentStatus
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.time.Instant
import java.util.UUID

@Entity
@Table(name = "orders")
class Order {
    @Id
    lateinit var id: UUID

    @Column(name = "customer_id", nullable = false)
    lateinit var customerId: UUID

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    lateinit var customer: Customer

    @Column(name = "payment_status")
    @Enumerated(EnumType.STRING)
    lateinit var paymentStatus: PaymentStatus

    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    lateinit var orderStatus: OrderStatus

    @OneToMany(mappedBy = "orderId", cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
    var details: MutableList<OrderDetail> = mutableListOf()

    lateinit var created: Instant

    lateinit var updated: Instant
}