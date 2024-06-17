package br.com.fiap.neoinbox.entrada

import UserPreferences
import androidx.lifecycle.ViewModel
import androidx.room.ColumnInfo
import br.com.fiap.neoinbox.model.Conta
import br.com.fiap.neoinbox.model.Email
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class EntradaScreenViewModel(userPreferences: UserPreferences): ViewModel() {

    val userEmail: Flow<String?> = userPreferences.userEmail
    val userSenha: Flow<String?> = userPreferences.userSenha

//    fun verTodosOsEmailsViewModel(codContaFK): List<Email>{
//         MutableState<List<Conta>>,
//    }

}