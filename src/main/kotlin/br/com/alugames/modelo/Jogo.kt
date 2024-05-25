package org.example.br.com.alugames.modelo

data class Jogo( val titulo:String,
            val capa:String,
           ){ // construtor
            var descricao:String? = null //pode ser null
            var preco = 0.0

    constructor(titulo: String,capa: String,preco:Double,descricao:String):this(titulo,capa){
        this.preco =preco
        this.descricao = descricao
    }
    //CONVERTENDO PARA QUE POSSA LER COMO STRING EM MAIN PRINCIPAL
    override fun toString(): String {
        return "meu jogo (titulo='$titulo', capa='$capa', descricao='$descricao'), preço: ${preco}"
    }
}