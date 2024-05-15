package org.example.br.com.alugames.modelo

class Jogo( val titulo:String,
            val capa:String,
           ){ // construtor
            var descricao:String? = null //pode ser null

    //CONVERTENDO PARA QUE POSSA LER COMO STRING EM MAIN PRINCIPAL
    override fun toString(): String {
        return "meu jogo (titulo='$titulo', capa='$capa', descricao='$descricao')"
    }
}