package com.abdielini.hucar.Hucar.service

import com.abdielini.hucar.Hucar.db.LlantasRepository
import com.abdielini.hucar.Hucar.model.Llantas
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class LlantasServiceImpl : LlantasService() {

    @Autowired
    lateinit var llantasRepository: LlantasRepository

    fun getAllLlantas(): List<Llantas> {
        return llantasRepository.findAll()
    }

    fun getLlantasById(id: String): Optional<Llantas> {
        return llantasRepository.findById(id)
    }

    fun saveLlantas(llantas: Llantas): Llantas {
        return llantasRepository.save(llantas)
    }


    fun updateLlantas(id: String, llantas: Llantas): Llantas {
        llantasRepository.findById(id).let {
            if (it != null) {
                llantas.id = it.get().id
            }
        }
        return llantasRepository.save(llantas)
    }

    fun deleteLlantas(id: String) {
        return llantasRepository.deleteById(id)
    }
}
