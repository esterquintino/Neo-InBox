package br.com.fiap.neoinbox.cadastro

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CadastroScreenViewModel: ViewModel() {
    private val _nome = MutableLiveData<String>()
    val nome: LiveData<String> = _nome

    private val _sobrenome = MutableLiveData<String>()
    val sobrenome: LiveData<String> = _sobrenome

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _senha = MutableLiveData<String>()
    val senha: LiveData<String> = _senha

    private val _nrtelefone = MutableLiveData<Int>()
    val nrtelefone: LiveData<Int> = _nrtelefone

    fun onNomeChanged(novoNome:String){
        _nome.value = novoNome
    }

    fun onSobrenomeChanged(novoSobrenome:String){
        _sobrenome.value = novoSobrenome
    }
    fun onEmailChanged(novoEmail:String){
        _email.value = novoEmail
    }

    fun onSenhaChanged(novaSenha:String){
        _senha.value = novaSenha
    }

    fun onNrTelefoneChanged(novoNrTelefone:Int){
        _nrtelefone.value = novoNrTelefone
    }

    fun cadastrarContaViewModel(): Boolean {
        // logica de cadastro
        return true
    }
}