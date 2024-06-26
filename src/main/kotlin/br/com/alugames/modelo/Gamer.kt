package br.com.alugames.modelo
import org.example.br.com.alugames.modelo.Jogo
import java.time.LocalDate
import java.util.Scanner
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

    var plano:Plano = PlanoAvulso("BRONZE")

    val jogosBuscados = mutableListOf<Jogo?>() //criando uma lista para busca de jogos e passando ${jogo?} <<-- pode ser nulo
    val jogosALugados = mutableListOf<Aluguel>()

    //CONSTRUTOR
    constructor(nome: String,email: String,dataNascimento:String, usuario:String):this(nome, email) {//criando um construtor
         this.dataNascimento = dataNascimento
         this.usuario =usuario
         criarIdInterno()
    }
    //validações
    init { //executar algum bloco de código antes de inicializar a classe
        if (nome.isNullOrBlank()){
            throw IllegalArgumentException("nome esta em branco")
        }
        this.email =validadarEmail()
    }// fim validações
    override fun toString(): String {
        return "Gamer(nome='$nome', email='$email', dataNascimento=$dataNascimento, usuario=$usuario, idInterno=$idInterno)"
    }

    //criando idEnterno
    fun criarIdInterno(){
        val numero = Random.nextInt(1000)
        val tag = String.format("#04d",numero)

        this.idInterno = "$usuario#$tag " //passando id interno para formatação
    }//fim criação id interno

    //validação de email
    fun validadarEmail(): String{
        val regex = Regex(pattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")

        if (regex.matches(email)){ // matches especifica uma expressão regular e localiza o conteúdo do objeto String em que está sendo aplicada essa expressão
            return  email
        }
        else{
        throw IllegalArgumentException("email invalido") //A palavra reservada throw dispara um erro criado pelo programa em tempo de execução
        }
    }//fim validação email

    //Aluguel
    fun alugaJogo(jogo: Jogo,periodo: Periodo): Aluguel{
        val aluguel= Aluguel(this,jogo,periodo)
        jogosALugados.add(aluguel)

        return aluguel
    }//fim Aluguel

    //criando um filtro de aluguel de games por mes
    fun jogosDoMes(mes:Int): List<Jogo>{
        return  jogosALugados
            .filter {aluguel ->aluguel.periodo.dataInicial.monthValue == mes }
            .map {aluguel -> aluguel.jogo}
    }//fim filtro de aluguel

    companion object{ //criando esse objeto para que possa ser executado na main principal
        fun criarGAMER(leitura:Scanner): Gamer{
            println("Boas vindas ao ROGAMES! Vamos fazer seu cadastro. Digite seu nome:")
            val nome = leitura.nextLine()
            println("Digite seu e-mail:")
            val email = leitura.nextLine()
            println("Deseja completar seu cadastro com usuário e data de nascimento? (S/N)")
            val opcao = leitura.nextLine()

            if (opcao.equals("s", ignoreCase = true)) {
                println("Digite sua data de nascimento(DD/MM/AAAA):")
                val nascimento = leitura.nextLine()
                println("Digite seu nome de usuário:")
                val usuario = leitura.nextLine()

                return  Gamer(nome, email,nascimento,usuario)
            }else{
                return  Gamer(nome, email)
            }
        }
    }
}
