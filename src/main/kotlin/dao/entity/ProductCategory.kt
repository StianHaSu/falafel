package dao.entity

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import java.util.UUID
import Category
import jakarta.persistence.Id
import jakarta.persistence.IdClass

@Entity
@IdClass(ProductCategoryKey::class)
class ProductCategory {
    @Id
    lateinit var productId: UUID

    @Id
    @Enumerated(EnumType.STRING)
    lateinit var category: Category
}