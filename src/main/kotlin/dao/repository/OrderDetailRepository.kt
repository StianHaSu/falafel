package dao.repository

import dto.OrderDetailRequest
import java.util.UUID

interface OrderDetailRepository {
    fun insertOrderDetails(orderDetailDtos: List<OrderDetailRequest>, orderId: UUID)
}