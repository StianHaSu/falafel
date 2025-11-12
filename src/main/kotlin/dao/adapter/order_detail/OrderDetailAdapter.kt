package dao.adapter.order_detail

import dto.OrderDetailRequest
import java.util.UUID

abstract class OrderDetailAdapter<T> {

    abstract fun fromOrderDetailDto(orderDetailDto: OrderDetailRequest, orderId: UUID, productId: UUID): T
}