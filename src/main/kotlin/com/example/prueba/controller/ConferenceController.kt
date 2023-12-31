package com.example.prueba.controller

import com.example.prueba.model.Conference
import com.example.prueba.service.ConferenceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/conference")   //endpoint
class ConferenceController {
    @Autowired
    lateinit var conferenceService: ConferenceService

    @GetMapping
    fun list ():List <Conference>{
        return conferenceService.list()
    }

    @PostMapping
    fun save (@RequestBody conference: Conference): ResponseEntity<Conference> {
        return ResponseEntity(conferenceService.save(conference), HttpStatus.OK )
    }

    @PutMapping
    fun update (@RequestBody conference: Conference): ResponseEntity<Conference> {
        return ResponseEntity(conferenceService.update(conference), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody conference: Conference): ResponseEntity<Conference> {
        return ResponseEntity(conferenceService.updateName(conference), HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean? {
        return conferenceService.delete(id)
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*> {
        return ResponseEntity(conferenceService.listById (id), HttpStatus.OK)

    }
}