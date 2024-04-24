package com.abdielini.hucar.Hucar.service

import com.abdielini.hucar.Hucar.model.Llantas

open class LlantasService {
    interface LlantasService {
        fun getAllLlantas(): List<Llantas>
        fun getLlantasById(id: String): Llantas?
        fun saveLlantas(llantas: Llantas): Llantas
        fun updateLlantas(id: String, llantas: Llantas): Llantas
        fun deleteLlantas(id: String)
    }

}