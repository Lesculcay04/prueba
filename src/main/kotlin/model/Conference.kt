package com.example.prueba.model

import jakarta.persistence.*

@Entity
@Table(name = "conference")
class Conference {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var title: String? = null
    var descripcion: String? = null
    var city: String? = null
    @Column (name="total_assistains")
    var totalAssistains: Long? = null
}