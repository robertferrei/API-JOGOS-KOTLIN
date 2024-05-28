package br.com.alugames.modelo
 //open class Esta aberta a receber heranças
open class Plano(val tipo: String){

     open fun obterValor(aluguel: Aluguel):Double{
         return aluguel.jogo.preco * aluguel.periodo.emDias

     }
}