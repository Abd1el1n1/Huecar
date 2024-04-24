package com.abdielini.hucar.Hucar.controller

import com.abdielini.hucar.Hucar.model.Llantas
import com.abdielini.hucar.Hucar.service.LlantasServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/llantas")
class LlantasController {

    @Autowired
    lateinit var llantasService: LlantasServiceImpl

    @GetMapping
    fun getAllLlantas(): List<Llantas> {
        return llantasService.getAllLlantas()
    }

    @GetMapping("/{id}")
    fun getLlantasById(@PathVariable id: String): ResponseEntity<Llantas>? {
        val llantas = llantasService.getLlantasById(id)
        return llantas.let { ResponseEntity.ok(it.get()) }
    }

    @PostMapping
    fun saveLlantas(@RequestBody llantas: Llantas): ResponseEntity<Llantas> {
        val savedLlantas = llantasService.saveLlantas(llantas)
        return ResponseEntity.ok(savedLlantas)
    }

    @PutMapping("/{id}")
    fun updateLlantas(@PathVariable id: String, @RequestBody llantas: Llantas): ResponseEntity<Llantas> {
        val updatedLlantas = llantasService.updateLlantas(id, llantas)
        return ResponseEntity.ok(updatedLlantas)
    }

    @DeleteMapping("/{id}")
    fun deleteLlantas(@PathVariable id: String): ResponseEntity<Void> {
        llantasService.deleteLlantas(id)
        return ResponseEntity.noContent().build()
    }
}
