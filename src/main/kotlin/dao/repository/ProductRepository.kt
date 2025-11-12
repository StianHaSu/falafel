package dao.repository

import dto.ProductDto
import dto.ProductRequest
import java.util.UUID

interface ProductRepository {
    fun insertProduct(product: ProductRequest, id: UUID)

    fun getProducts(): List<ProductDto>

    fun getProductById(id: UUID): ProductDto?
}