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

    @Delete
    fun excluirConta(conta: Conta): Int

    @Query("SELECT * FROM tbl_conta WHERE cod_Conta = :id")
    fun buscarConta(id: Int): Conta

    @Update
    fun recuperarSenha(conta: Conta): Int

}