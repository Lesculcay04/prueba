package com.example.prueba.service

import com.example.prueba.model.Assistant
import com.example.prueba.repository.AssistantRepository
import com.example.prueba.repository.ConferenceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class AssistantService {
    @Autowired
    lateinit var conferenceRepository: ConferenceRepository
    @Autowired
    lateinit var assistantRepository: AssistantRepository

    fun list ():List<Assistant>{
        return assistantRepository.findAll()
    }

    fun save(assistant: Assistant):Assistant{
        try {
            conferenceRepository.findById(assistant.conferenceId)
                    ?: throw Exception("Id del cliente no encontrada")
            return assistantRepository.save(assistant)
        }catch (ex : Exception){
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }
    fun update(assistant: Assistant): Assistant {
        try {
            assistantRepository.findById(assistant.id)
                    ?: throw Exception("ID no existe")

            return assistantRepository.save(assistant)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateName(assistant: Assistant): Assistant{
        try{
            val response = assistantRepository.findById(assistant.id)
                    ?: throw Exception("ID no existe")
            response.apply {
                age=assistant.age //un atributo del modelo
            }
            return assistantRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun delete (assistantId: Long?):Boolean?{
        try{
            val response = assistantRepository.findById(assistantId)
                    ?: throw Exception("ID no existe")
            assistantRepository.deleteById(assistantId!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun listById (assistantId:Long?): Assistant?{
        return assistantRepository.findById(assistantId)
    }

}