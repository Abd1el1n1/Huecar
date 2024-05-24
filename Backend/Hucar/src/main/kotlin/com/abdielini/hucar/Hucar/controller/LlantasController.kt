package com.abdielini.hucar.Hucar.controller

import com.abdielini.hucar.Hucar.model.Llantas
import com.abdielini.hucar.Hucar.service.LlantasServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Files
import java.nio.file.Paths


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

    @PutMapping
    fun updateLlantas(@RequestPart("llantas") llantas: Llantas, @RequestPart("photos") photos: List<MultipartFile>): ResponseEntity<Llantas> {
        val savedPhotosPaths = savePhotos(photos, llantas.id)
        llantas.imagenPath1 = savedPhotosPaths[0]
        llantas.imagenPath2 = savedPhotosPaths[1]
        llantas.imagenPath3 = savedPhotosPaths[2]
        val updatedLlantas = llantasService.updateLlantas(llantas.id, llantas)
        return ResponseEntity.ok(updatedLlantas)
    }

    @PostMapping
    fun saveLlantas(@RequestPart("llantas") llantas: Llantas, @RequestPart("photos") photos: List<MultipartFile>): ResponseEntity<Llantas> {
        val savedPhotosPaths = savePhotos(photos, llantas.id)
        llantas.imagenPath1 = savedPhotosPaths[0]
        llantas.imagenPath2 = savedPhotosPaths[1]
        llantas.imagenPath3 = savedPhotosPaths[2]
        val savedLlantas = llantasService.saveLlantas(llantas)
        return ResponseEntity.ok(savedLlantas)
    }

    fun savePhotos(photos: List<MultipartFile>, id: String): List<String> {
        val savedPhotosPaths = mutableListOf<String>()
        for ((index, photo) in photos.withIndex()) {
            val fileName = "${id}_${index}"
            val targetLocation = Paths.get("/home/abdiel/Documents/photos/$fileName")
            Files.copy(photo.inputStream, targetLocation)
            savedPhotosPaths.add(fileName)
        }
        return savedPhotosPaths
    }


    @DeleteMapping("/{id}")
    fun deleteLlantas(@PathVariable id: String): ResponseEntity<Void> {
        llantasService.deleteLlantas(id)
        return ResponseEntity.noContent().build()
    }
}
