package dao.repository

import Category
import dao.entity.ProductCategory
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import java.util.UUID

@ApplicationScoped
class PanacheProductCategoryRepository : PanacheRepository<ProductCategory>, ProductCategoryRepository {
    override fun addCategoryToProduct(productId: UUID, category: Category) {
        ProductCategory()
            .apply {
                this.category = category
                this.productId = productId
            }.let { persist(it) }
    }

    override fun removeCategoryFromProduct(productId: UUID, category: Category) {
        delete("productId = ?1 and category = ?2", productId, category)
    }

    override fun addCategoriesToProduct(productId: UUID, categories: List<Category>) {
        categories.forEach { category ->
            addCategoryToProduct(productId, category)
        }
    }
}