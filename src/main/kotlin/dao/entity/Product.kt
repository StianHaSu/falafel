package dao.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal
import java.util.UUID

@Entity(name = "products")
@Table(name = "products")
class Product {
    @Id
    lateinit var id: UUID

    lateinit var name: String

    var description: String? = null

    lateinit var price: BigDecimal

    var imageUrl: String? = null
}