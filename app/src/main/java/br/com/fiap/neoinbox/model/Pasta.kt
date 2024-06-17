package br.com.fiap.neoinbox.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_pasta")
data class Pasta(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "cod_pasta")
    var codPasta: Int = 0,
    @ColumnInfo(name = "nm_pasta")
    var nmPasta: String = "",
)
