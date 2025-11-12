package dao.adapter.order_detail

import dao.entity.OrderDetail
import dto.OrderDetailRequest
import jakarta.enterprise.context.ApplicationScoped
import java.util.UUID

@ApplicationScoped
class PanacheOrderDetailAdapter : OrderDetailAdapter<OrderDetail>() {
    override fun fromOrderDetailDto(orderDetailDto: OrderDetailRequest, orderId: UUID, productId: UUID): OrderDetail {
        val orderDetail = OrderDetail()
        orderDetail.orderId = orderId
        orderDetail.productId = productId
        orderDetail.quantity = orderDetailDto.quantity
        orderDetail.productId = orderDetailDto.productId

        return orderDetail
    }
}