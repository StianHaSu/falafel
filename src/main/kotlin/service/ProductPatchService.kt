package service

import dao.repository.ProductCategoryRepository
import dao.repository.ProductRepository
import dto.request.CategoryPatchRequest
import dto.request.ProductPatchRequest
import jakarta.enterprise.context.ApplicationScoped
import java.util.UUID

@ApplicationScoped
class ProductPatchService(
    private val productRepository: ProductRepository,
    private val productCategoryRepository: ProductCategoryRepository
) {

    fun applyPatch(productId: UUID, patch: ProductPatchRequest) {
        patch.productName?.let { name -> productRepository.updateName(productId, name) }
        patch.price?.let { price -> productRepository.updatePrice(productId, price) }
        patch.categoryUpdates?.let { categoryUpdates -> applyCategoryChanges(productId, categoryUpdates) }
        patch.productDescription?.let { description -> productRepository.updateDescription(productId, description) }
    }

    private fun applyCategoryChanges(productId: UUID, categoryChanges: CategoryPatchRequest) {
        categoryChanges.add?.let { toAdd ->
            productCategoryRepository.addCategoriesToProduct(productId, toAdd)
        }

        categoryChanges.remove?.let { toRemove ->
            toRemove.forEach { category ->
                productCategoryRepository.removeCategoryFromProduct(productId, category)
            }
        }
    }
}