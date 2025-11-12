package dto

import dao.entity.OrderDetail

fun OrderDetail.toOrderDetailDto() = OrderDetailDto(
    this.productId,
    this.product.name,
    this.orderId,
    this.quantity,
)