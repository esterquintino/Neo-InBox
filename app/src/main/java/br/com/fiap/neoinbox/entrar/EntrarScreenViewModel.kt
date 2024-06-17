package br.com.fiap.neoinbox.entrar

import UserPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class EntrarScreenViewModel(private val userPreferences: UserPreferences): ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _senha = MutableLiveData<String>()
    val senha: LiveData<String> = _senha

    private val _entrarSucesso = MutableLiveData<Boolean>()
    val entrarSucesso: LiveData<Boolean> = _entrarSucesso

    fun onEmailChanged(novoEmail: String) {
        _email.value = novoEmail
    }

    fun onSenhaChanged(novaSenha: String) {
        _senha.value = novaSenha
    }

    fun entrarNaContaViewModel(): Pair<String, String> {
        val email = _email.value!!
        val senha = _senha.value!!
        return Pair(email, senha)
    }

    fun saveUser(email: String, senha: String) {
        viewModelScope.launch {
            userPreferences.saveUser(email, senha)
        }
    }
}