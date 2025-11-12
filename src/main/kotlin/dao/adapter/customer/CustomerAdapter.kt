package dao.adapter.customer

import dto.CustomerDto
import dto.CustomerRequest
import java.util.UUID

abstract class CustomerAdapter<T> {

    abstract fun toCustomerDto(customer: T): CustomerDto

    abstract fun fromCustomerRequest(customerRequest: CustomerRequest, id: UUID): T
}