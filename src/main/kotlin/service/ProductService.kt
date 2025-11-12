package service

import dao.repository.ProductRepository
import dto.ProductDto
import dto.ProductRequest
import jakarta.enterprise.context.ApplicationScoped
import java.util.UUID

@ApplicationScoped
class ProductService(private val productRepository: ProductRepository) {

    fun createProduct(product: ProductRequest): UUID =
        UUID.randomUUID().also { id -> productRepository.insertProduct(product, id) }

    fun getAllProducts(): List<ProductDto> = productRepository.getProducts()
}