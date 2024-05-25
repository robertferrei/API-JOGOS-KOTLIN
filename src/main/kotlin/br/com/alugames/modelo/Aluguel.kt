package br.com.alugames.modelo

import org.example.br.com.alugames.modelo.Jogo
import java.time.LocalDate
import java.time.Period

data class Aluguel(val gamer: Gamer,
                   val jogo: Jogo,
                   val dataInicial:LocalDate,
                   val dataFinal:LocalDate){
                    val valorDoAluguel = jogo.preco * Period.between(dataInicial,dataFinal).days //calculo de aluguel
    override fun toString(): String {
        return "Aluguel do  ${jogo.titulo} por ${gamer.nome} valor aluguel R$ ${valorDoAluguel})"
    }
}
