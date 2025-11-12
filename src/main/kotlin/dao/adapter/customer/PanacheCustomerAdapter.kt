package dao.adapter.customer

import dao.entity.Customer
import dto.CustomerDto
import dto.CustomerRequest
import jakarta.enterprise.context.ApplicationScoped
import java.util.UUID

@ApplicationScoped
class PanacheCustomerAdapter : CustomerAdapter<Customer>() {

    override fun toCustomerDto(customer: Customer): CustomerDto {
        return CustomerDto(
            customer.id,
            customer.nickname,
            customer.phoneNumber
        )
    }

    override fun fromCustomerRequest(customerRequest: CustomerRequest, id: UUID): Customer {
        val customer = Customer()

        customer.id = id
        customer.nickname = customerRequest.nickname
        customer.phoneNumber = customerRequest.phoneNumber

        return customer
    }
}