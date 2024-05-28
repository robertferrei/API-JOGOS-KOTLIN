import br.com.alugames.modelo.Periodo
import br.com.alugames.modelo.PlanoAssinatura
import br.com.alugames.servicos.CosnumoApi
import java.time.LocalDate

fun main(){
    val consumo = CosnumoApi()
    val listaGamer = consumo.buscaGamer()
    val listaJogo = consumo.buscaJogosJson()

    val gamer1  = listaGamer.get(3)
    val jogo1 = listaJogo.get(10)
    val jogo2 = listaJogo.get(2)
    val jogo3 = listaJogo.get(13)


    val periodo = Periodo(LocalDate.now(), LocalDate.now().plusDays(8))
    val periodo1 = Periodo(LocalDate.now(), LocalDate.now().plusDays(8))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(6))

    val periodo4 = Periodo(LocalDate.of(2023,8,2), LocalDate.of(2023,8,15))

    gamer1.alugaJogo(jogo1,periodo)
    gamer1.alugaJogo(jogo2,periodo1)
    gamer1.alugaJogo(jogo3,periodo2)

    //println(gamer1.jogosALugados)
    gamer1.alugaJogo(jogo3,periodo4)
    gamer1.alugaJogo(jogo2,periodo)


    //println(gamer1.jogosDoMes(8))

    val gamer2 = listaGamer.get(5)
    gamer2.plano = PlanoAssinatura("PRATA",9.90, 3)
    gamer2.alugaJogo(jogo1,periodo2)
    gamer2.alugaJogo(jogo2,periodo1)
    gamer2.alugaJogo(jogo3,periodo)
    gamer2.alugaJogo(jogo3,periodo2)

    println(gamer2.jogosALugados)

}