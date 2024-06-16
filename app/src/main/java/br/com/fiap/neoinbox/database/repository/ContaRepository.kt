package br.com.fiap.neoinbox.database.repository

import android.content.Context
import br.com.fiap.neoinbox.database.dao.ContaDb
import br.com.fiap.neoinbox.model.Conta

class ContaRepository (context: Context) {
    var db = ContaDb.getDatabase(context).contaDao()

    fun salvarConta(conta: Conta): Long{
        return db.salvarConta(conta = conta)
    }

    fun atualizarConta(conta: Conta): Int{
        return db.atualizarConta(conta = conta)
    }

    fun excluirConta(conta: Conta): Int{
        return db.excluirConta(conta = conta)
    }

    fun entrarNaConta(email: String, senha: String): Int{
        return db.entrarNaConta(email = email, senha = senha)
    }

    fun recuperarSenha(conta: Conta): Int{
        return db.recuperarSenha(conta = conta)
    }
}