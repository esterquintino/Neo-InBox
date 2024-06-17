package br.com.fiap.neoinbox.database.repository

import android.content.Context
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import br.com.fiap.neoinbox.database.dao.NeoinboxDb
import br.com.fiap.neoinbox.model.Email

class EmailRepository(context: Context) {
    var db = NeoinboxDb.getDatabase(context).emailDao()

    fun criarEmail(email: Email): Long{
        return db.criarEmail(email)
    }

    fun excluirEmail(email: Email): Int{
        return db.excluirEmail(email)
    }

    fun editarEmail(email: Email): Int{
        return db.editarEmail(email)
    }

    fun verEmail(codEmail: Long, codContaFK: Long): Email{
        return db.verEmail(codEmail, codContaFK)
    }

    fun verTodosOsEmails(codContaFK: Long): List<Email>{
        return db.verTodosOsEmails(codContaFK)
    }

}