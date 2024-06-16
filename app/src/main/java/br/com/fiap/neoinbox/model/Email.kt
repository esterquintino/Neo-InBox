package br.com.fiap.neoinbox.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(
    tableName = "tbl_email",
    foreignKeys = [
        ForeignKey(
            entity = Pasta::class,
            parentColumns = ["cod_pasta"],
            childColumns = ["cod_pasta_fk"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Conta::class,
            parentColumns = ["cod_conta"],
            childColumns = ["cod_conta_fk"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Email(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "cod_email")
    var codEmail: Int = 0,
    @ColumnInfo(name = "tt_email")
    var ttEmail: String = "",
    @ColumnInfo(name = "tx_email")
    var txEmail: String = "",
    @ColumnInfo(name = "end_remetente")
    var endRemetente: String = "",
    @ColumnInfo(name = "end_destinatario")
    var endDestinatario: String = "",
    @ColumnInfo(name = "dt_email")
    var dtEmail: LocalDate,
    @ColumnInfo(name = "hr_email")
    var hrEmail: Int,
    @ColumnInfo(name = "end_destinatario_cc")
    var endDestinatarioCC: String = "",
    @ColumnInfo(name = "cod_pasta_fk")
    var codPastaFK: Int? = null,
    @ColumnInfo(name = "cod_conta_fk")
    var codContaFK: Int? = null
)
