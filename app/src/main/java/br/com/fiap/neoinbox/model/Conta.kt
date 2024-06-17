package br.com.fiap.neoinbox.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_conta",
    indices = [Index(value = ["end_email"], unique = true)])
data class Conta(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "cod_conta")
    var codConta: Int = 0,
    var nome: String = "",
    var sobrenome: String = "",
    @ColumnInfo(name = "end_email")
    var endEmail: String = "",
    var senha: String = "",
    @ColumnInfo(name = "nm_telefone")
    var nmTelefone: Long = 0
)
