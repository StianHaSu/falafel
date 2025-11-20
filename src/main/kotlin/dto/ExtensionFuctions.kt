package dto

import dao.entity.OrderDetail
import dto.internal.OrderDetailDto
import dto.internal.OrderDto
import dto.response.OrderResponse

fun OrderDetail.toOrderDetailDto() = OrderDetailDto(
    this.productId,
    this.product.name,
    this.orderId,
    this.quantity,
    this.product.price.toDouble()
)

fun OrderDto.toOrderResponse() = OrderResponse(
    this.id,
    this.customer,
    this.paymentStatus,
    this.orderStatus,
    this.created,
    this.details
        .map { it.price }
        .reduce { sum, element -> sum + element },
    this.details
)