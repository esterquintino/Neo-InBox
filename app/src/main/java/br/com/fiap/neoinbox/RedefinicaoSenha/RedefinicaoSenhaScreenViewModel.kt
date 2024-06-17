package br.com.fiap.neoinbox.RedefinicaoSenha

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fiap.neoinbox.model.Conta

class RedefinicaoSenhaScreenViewModel: ViewModel() {

    private val _novaSenha = MutableLiveData<String>()
    val novaSenha: LiveData<String> = _novaSenha

    fun onNovaSenhaChanged(novaNovaSenha:String){
        _novaSenha.value = novaNovaSenha
    }

    fun redefinicaoSenhaScreenViewModel(email: String): Pair<String, String> {
            var endEmail = email!!
            var senha = _novaSenha.value!!
        return return Pair(endEmail, senha)
    }
}