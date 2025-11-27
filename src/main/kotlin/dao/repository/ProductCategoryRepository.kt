package dao.repository

import Category
import java.util.UUID

interface ProductCategoryRepository {
    fun addCategoryToProduct(productId: UUID, category: Category)

    fun removeCategoryFromProduct(productId: UUID, category: Category)

    fun addCategoriesToProduct(productId: UUID, categories: List<Category>)
}