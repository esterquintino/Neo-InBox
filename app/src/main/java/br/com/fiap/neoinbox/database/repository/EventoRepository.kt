package br.com.fiap.neoinbox.database.repository

import android.content.Context
import br.com.fiap.neoinbox.database.dao.NeoinboxDb
import br.com.fiap.neoinbox.model.Conta
import br.com.fiap.neoinbox.model.Evento

class EventoRepository(context: Context) {
    var db = NeoinboxDb.getDatabase(context).eventoDao()

    fun salvarEvento(evento: Evento): Long{
        return db.salvarEvento(evento = evento)
    }

    fun atualizarEvento(evento: Evento): Int{
        return db.atualizarEvento(evento = evento)
    }
    fun excluirEvento(evento: Evento): Int{
        return db.excluirEvento(evento = evento)
    }
    fun listarEventos(codContaFK: Long): List<Evento>{
        return db.listarEventos(codContaFK)
    }
}