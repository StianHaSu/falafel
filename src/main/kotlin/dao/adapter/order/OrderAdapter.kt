package dao.adapter.order

import dto.OrderDto
import dto.OrderRequest
import java.util.UUID

abstract class OrderAdapter<T> {

    abstract fun toOrderDto(order: T): OrderDto

    abstract fun fromOrderRequest(orderRequest: OrderRequest, id: UUID, customerId: UUID): T
}