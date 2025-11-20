package dao.adapter.order

import dto.internal.OrderDto
import dto.request.OrderRequest
import java.util.UUID

abstract class OrderAdapter<T> {

    abstract fun toOrderDto(order: T): OrderDto

    abstract fun fromOrderRequest(orderRequest: OrderRequest, id: UUID, customerId: UUID): T
}