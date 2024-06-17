package br.com.fiap.neoinbox.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.fiap.neoinbox.model.Conta

@Dao
interface ContaDao {
    @Insert
    fun salvarConta(conta: Conta): Long

    @Update
    fun atualizarConta(conta: Conta): Int

    @Query("UPDATE tbl_conta SET senha = :senha WHERE end_email = :email")
    fun redefinirSenha(email: String, senha: String): Int

    @Delete
    fun excluirConta(conta: Conta): Int

    @Query("SELECT * FROM tbl_conta WHERE end_email = :email")
    fun buscarConta(email: String): Conta

    @Query("SELECT COUNT(*) FROM tbl_conta WHERE end_email = :email AND senha = :senha")
    fun entrarNaConta(email: String, senha: String): Int

    @Update
    fun recuperarSenha(conta: Conta): Int

}