package br.com.fiap.neoinbox.database.repository

import android.content.Context
import br.com.fiap.neoinbox.database.dao.NeoinboxDb
import br.com.fiap.neoinbox.model.Pasta
import br.com.fiap.neoinbox.model.TipoPasta

class PastaRepository(context: Context) {
    var db = NeoinboxDb.getDatabase(context).pastaDao()

    fun salvarPasta(pasta: Pasta): Long {
        return db.salvarPasta(pasta = pasta)
    }

    fun atualizarPasta(pasta: Pasta): Int {
        return db.atualizarPasta(pasta = pasta)
    }

    fun excluirPasta(pasta: Pasta): Int {
        return db.excluirPasta(pasta = pasta)
    }

    fun listarPastas(): List<Pasta> {
        return db.listarPastas()
    }

    fun buscarPastaPorNome(nomePasta: String): Pasta? {
        return db.buscarPastaPorNome(nomePasta)
    }

    fun obterTipoPasta(tipoPasta: TipoPasta): Pasta? {
        return buscarPastaPorNome(tipoPasta.name)
    }
}
