package dao.repository

import dto.CustomerRequest

interface CustomerRepository {
    fun insertCustomer(customer: CustomerRequest)
}