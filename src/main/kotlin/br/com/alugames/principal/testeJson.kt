import br.com.alugames.servicos.CosnumoApi

fun main(){
    val consumo = CosnumoApi()
    val listaGamer = consumo.buscaGamer()
    val listaJogo = consumo.buscaJogosJson()

    val gamer1  = listaGamer.get(3)
    val jogo1 = listaJogo.get(10)

val luguel = gamer1.alugaJogo(jogo1)
    println(luguel)
1

}