package com.abdielini.hucar.Hucar.db

import com.abdielini.hucar.Hucar.model.Llantas
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface LlantasRepository : JpaRepository<Llantas, String> {
    // Function to retrieve all llantas
    override fun findAll(): List<Llantas>

    // Function to retrieve a llantas by its id (UPC)
    override fun findById(id: String): Optional<Llantas>

    // Function to save or update a llantas
    fun save(llantas: Llantas): Llantas

    // Function to delete a llantas by its id (UPC)
    override fun deleteById(id: String)
}
