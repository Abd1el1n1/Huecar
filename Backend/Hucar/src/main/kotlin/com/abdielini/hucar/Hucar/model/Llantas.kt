package com.abdielini.hucar.Hucar.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name = "llantas")
data class Llantas(
    @Id
    var id: String, // UPC as ID
    var inventario: Int,
    var marca: String,
    var descripcion: String,
    var imagenPath1: String?,
    var imagenPath2: String?,
    var imagenPath3: String?
) {
    constructor() : this("", 0, "", "", null, null, null)
}
