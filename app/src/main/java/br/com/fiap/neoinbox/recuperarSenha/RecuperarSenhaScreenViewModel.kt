package br.com.fiap.neoinbox.recuperarSenha

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RecuperarSenhaScreenViewModel: ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    fun onEmailChanged(novoEmail:String){
        _email.value = novoEmail
    }

    fun recuperarSenhaViewModel(): Boolean {
        //logica de recuperacao de senha
        return true
    }
}