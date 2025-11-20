package dao.repository

import dto.request.OrderDetailRequest
import java.util.UUID

interface OrderDetailRepository {
    fun insertOrderDetails(orderDetailDtos: List<OrderDetailRequest>, orderId: UUID)
}