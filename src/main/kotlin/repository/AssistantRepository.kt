package com.example.prueba.repository

import com.example.prueba.model.Assistant
import org.springframework.data.jpa.repository.JpaRepository

interface AssistantRepository: JpaRepository<Assistant, Long?> {
    fun findById (id: Long?): Assistant?
}