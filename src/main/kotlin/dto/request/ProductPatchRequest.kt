package dto.request

import Category

data class ProductPatchRequest(
    val price: Double?,
    val productName: String?,
    val productDescription: String?,
    val categoryUpdates: CategoryPatchRequest?,
)

data class CategoryPatchRequest(
    val add: List<Category>?,
    val remove: List<Category>?
)
