package dao.repository

import dto.internal.ProductDto
import dto.request.ProductRequest
import java.util.UUID

interface ProductRepository {
    fun insertProduct(product: ProductRequest, id: UUID)

    fun getProducts(): List<ProductDto>

    fun getProductById(id: UUID): ProductDto?

    fun deleteProduct(id: UUID)

    fun updateName(id: UUID, newName: String)

    fun updatePrice(id: UUID, price: Double)

    fun updateDescription(id: UUID, newDescription: String)
}