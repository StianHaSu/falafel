package dao.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.UUID

@Entity
class Customer {
    @Id
    lateinit var id: UUID
    lateinit var nickname: String
    lateinit var phoneNumber: String
}