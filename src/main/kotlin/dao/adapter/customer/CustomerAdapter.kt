package dao.adapter.customer

import dto.CustomerDto
import dto.CustomerRequest

abstract class CustomerAdapter<T> {

    abstract fun toCustomerDto(customer: T): CustomerDto

    abstract fun fromCustomerRequest(customerRequest: CustomerRequest): T
}