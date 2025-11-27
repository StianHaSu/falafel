package dto.request

import Category

data class ProductPatchRequest(
    val categoryUpdates: CategoryPatchRequest?,
    val price: Double?,
    val name: String?
)

data class CategoryPatchRequest(
    val add: List<Category>?,
    val remove: List<Category>?
)
