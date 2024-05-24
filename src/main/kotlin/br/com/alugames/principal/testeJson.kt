import br.com.alugames.servicos.CosnumoApi

fun main(){
    val consumo = CosnumoApi()
    val listaGamer = consumo.buscaGamer()
    println(listaGamer)
}