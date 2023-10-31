package com.example.prueba.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "assistant")
class Assistant {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @Column (name="full_name")
    var fullName: String? = null
    var role: String? = null
    var age: Int? = null
    @Column (name="conference_id")
    var conferenceId: Long? = null
}