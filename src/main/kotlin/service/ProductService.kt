package service

import Category
import dao.entity.ProductCategory
import dao.repository.ProductCategoryRepository
import dao.repository.ProductRepository
import dto.internal.ProductDto
import dto.request.ProductPatchRequest
import dto.request.ProductRequest
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity_.id
import jakarta.enterprise.context.ApplicationScoped
import org.slf4j.LoggerFactory
import java.util.UUID

@ApplicationScoped
class ProductService(
    private val productRepository: ProductRepository,
    private val productCategoryRepository: ProductCategoryRepository,
    private val productPatchService: ProductPatchService
) {
    private val logger = LoggerFactory.getLogger(ProductService::class.java)

    fun addCategoryToProduct(productId: UUID, category: Category) {
        productCategoryRepository.addCategoryToProduct(productId, category)
    }

    fun removeCategoryFromProduct(productId: UUID, category: Category) {
        productCategoryRepository.removeCategoryFromProduct(productId, category)
    }

    fun createProduct(product: ProductRequest): UUID =
        UUID.randomUUID().also { id -> productRepository.insertProduct(product, id) }
            .also { id ->
                product.categories?.let { category ->
                    productCategoryRepository.addCategoriesToProduct(id,category)
                }
            }
            .also { logger.info("Created a new product with id: $id and name: ${product.productName}") }

    fun getAllProducts(): List<ProductDto> = productRepository.getProducts()

    fun deleteProduct(id: UUID) = productRepository.deleteProduct(id)
        .also { logger.info("Product deleted: $it") }

    fun applyPatchToProduct(id: UUID, patch: ProductPatchRequest) {
        productPatchService.applyPatch(id, patch)
    }
}