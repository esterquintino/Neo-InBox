package br.com.fiap.neoinbox.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date

@Entity(
    tableName = "tbl_evento",
    foreignKeys =
    [
        ForeignKey(
            entity = Conta::class,
            parentColumns = ["cod_conta"],
            childColumns = ["cod_conta_fk"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Evento(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "cod_evento")
    var codEvento: Int = 0,
    @ColumnInfo(name = "nm_evento")
    var nmEvento: String = "",
    @ColumnInfo(name = "dt_evento")
    var dtEvento: String,
    @ColumnInfo(name = "hr_evento")
    var hrEvento: String,
    @ColumnInfo(name = "cod_conta_fk")
    var codContaFK: Int
)
