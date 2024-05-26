package br.com.alugames.modelo

import java.time.LocalDate
import java.time.Period

//calculo de dias para o Aluguel
data class Periodo(val dataInicial: LocalDate,
                  val dataFinal: LocalDate){
    val emDias = Period.between(dataInicial,dataFinal).days
}
