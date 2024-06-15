package br.com.fiap.neoinbox.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import br.com.fiap.neoinbox.model.Conta
import br.com.fiap.neoinbox.model.Email
import br.com.fiap.neoinbox.model.Pasta
import br.com.fiap.neoinbox.model.relationship.ContaWithEmails
import br.com.fiap.neoinbox.model.relationship.PastaWithEmails

@Dao
interface PastaDao {
    @Insert
    fun inserirPasta(pasta: Pasta)

    @Insert
    fun inserirEmail(email: Email)

    @Insert
    fun inserirConta(conta: Conta)

    @Transaction
    @Query("SELECT * FROM tbl_pasta WHERE cod_pasta = :id")
    fun getPastaWithEmails(id: Int): List<PastaWithEmails>

    @Transaction
    @Query("SELECT * FROM tbl_conta WHERE cod_conta = :id")
    fun getContaWithEmails(id: Int): List<ContaWithEmails>
}