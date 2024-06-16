package br.com.fiap.neoinbox.entrar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
class EntrarScreenViewModel: ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _senha = MutableLiveData<String>()
    val senha: LiveData<String> = _senha

    fun onEmailChanged(novoEmail:String){
        _email.value = novoEmail
    }

    fun onSenhaChanged(novaSenha:String){
        _senha.value = novaSenha
    }

    fun entrarNaContaViewModel(): Boolean {
        //navController.navigate("home")
        return true
    }

}