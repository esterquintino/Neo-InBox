package br.com.fiap.neoinbox.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import br.com.fiap.neoinbox.model.Conta
import br.com.fiap.neoinbox.model.Email
import br.com.fiap.neoinbox.model.Pasta
import br.com.fiap.neoinbox.model.relationship.ContaWithEmails
import br.com.fiap.neoinbox.model.relationship.PastaWithEmails

@Dao
interface PastaDao {
    @Insert
    fun salvarPasta(pasta: Pasta): Long

    @Update
    fun atualizarPasta(pasta: Pasta): Int

    @Delete
    fun excluirPasta(pasta: Pasta): Int

    @Query("SELECT * FROM tbl_pasta")
    fun listarPastas(): List<Pasta>

    @Query("SELECT * FROM tbl_pasta WHERE nm_pasta = :nomePasta LIMIT 1")
    fun buscarPastaPorNome(nomePasta: String): Pasta?

    @Transaction
    @Query("SELECT * FROM tbl_pasta WHERE cod_pasta = :id")
    fun getPastaWithEmails(id: Int): List<PastaWithEmails>

    @Transaction
    @Query("SELECT * FROM tbl_conta WHERE cod_conta = :id")
    fun getContaWithEmails(id: Int): List<ContaWithEmails>
}