package br.com.alugames.modelo
import kotlin.random.Random

//cadastros
data class Gamer(var nome:String, var email:String){
    var dataNascimento:String? = null
    var usuario:String? = null
        set(value) {
            field = value   //field = corpo , esta recebendo o valor
            if(idInterno.isNullOrBlank()){  //se  o id for nulo ou estar em branco vamos estar criando um novo id interno
                criarIdInterno()
            }
        }
     var idInterno:String? = null
         private set //conseguimos  usar esse valor para visualização porem nao podemos estar alterando

    //CONSTRUTOR
    constructor(nome: String,email: String,dataNascimento:String, usuario:String):this(nome, email) {//criando um construtor
         this.dataNascimento = dataNascimento
         this.usuario =usuario
         criarIdInterno()

    }
    init { //executar algum bloco de código antes de inicializar a classe
        if (nome.isNullOrBlank()){
            throw IllegalArgumentException("nome esta em branco")
        }
        this.email =validadarEmail()
    }
    override fun toString(): String {
        return "Gamer(nome='$nome', email='$email', dataNascimento=$dataNascimento, usuario=$usuario, idInterno=$idInterno)"
    }
    fun criarIdInterno(){
        val numero = Random.nextInt(1000)
        val tag = String.format("#04d",numero)

        this.idInterno = "$usuario#$tag " //passando id interno para formatação
    }
    fun validadarEmail(): String{
        val regex = Regex(pattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")

        if (regex.matches(email)){ // matches especifica uma expressão regular e localiza o conteúdo do objeto String em que está sendo aplicada essa expressão
            return  email
        }
        else{
        throw IllegalArgumentException("email invalido") //A palavra reservada throw dispara um erro criado pelo programa em tempo de execução
        }
    }
}
