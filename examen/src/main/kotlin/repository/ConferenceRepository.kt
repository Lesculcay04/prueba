package repository

import model.Conference
import org.springframework.data.jpa.repository.JpaRepository

interface ConferenceRepository: JpaRepository<Conference, Long?> {
    fun findById (id: Long?): Conference?
}