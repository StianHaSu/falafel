package dao.adapter.product

import dto.ProductDto
import dto.ProductRequest

abstract class ProductAdapter<T> {
    abstract fun fromOrderRequest(productRequest: ProductRequest): T

    abstract fun toProductDto(product: T): ProductDto
}