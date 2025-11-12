package dao.adapter.order

import dto.OrderDto
import dto.OrderRequest

abstract class OrderAdapter<T> {

    abstract fun toOrderDto(order: T): OrderDto

    abstract fun fromOrderRequest(dto: OrderRequest): T
}