package dao.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID


@Entity
@Table(name = "customers")
class Customer {
    @Id
    lateinit var id: UUID
    lateinit var nickname: String
    lateinit var phoneNumber: String
}