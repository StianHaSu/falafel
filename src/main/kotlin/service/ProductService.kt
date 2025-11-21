package service

import dao.repository.ProductRepository
import dto.internal.ProductDto
import dto.request.ProductRequest
import jakarta.enterprise.context.ApplicationScoped
import org.slf4j.LoggerFactory
import java.util.UUID

@ApplicationScoped
class ProductService(private val productRepository: ProductRepository) {
    private val logger = LoggerFactory.getLogger(ProductService::class.java)

    fun createProduct(product: ProductRequest): UUID =
        UUID.randomUUID().also { id -> productRepository.insertProduct(product, id) }

    fun getAllProducts(): List<ProductDto> = productRepository.getProducts()

    fun deleteProduct(id: UUID) = productRepository.deleteProduct(id)
        .also { logger.info("Product deleted: $it") }
}