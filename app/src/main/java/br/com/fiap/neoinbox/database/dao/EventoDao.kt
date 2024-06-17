package br.com.fiap.neoinbox.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.fiap.neoinbox.model.Conta
import br.com.fiap.neoinbox.model.Evento

@Dao
interface EventoDao {
    @Insert
    fun salvarEvento(evento: Evento): Long

    @Update
    fun atualizarEvento(evento: Evento): Int

    @Delete
    fun excluirEvento(evento: Evento): Int

    @Query("SELECT * FROM tbl_evento WHERE cod_conta_fk = :codContaFK")
    fun listarEventos(codContaFK: Long): List<Evento>

}