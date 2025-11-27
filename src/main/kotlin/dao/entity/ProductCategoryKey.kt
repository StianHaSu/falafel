package dao.entity

import Category
import jakarta.persistence.Column
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import java.io.Serializable
import java.util.UUID

class ProductCategoryKey: Serializable {
    @Id
    @Column(name = "product_id")
    lateinit var productId: UUID

    @Id
    @Column(name = "order_id")
    @Enumerated(EnumType.STRING)
    lateinit var category: Category
}