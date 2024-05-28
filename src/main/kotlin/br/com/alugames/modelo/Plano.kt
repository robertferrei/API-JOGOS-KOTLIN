package br.com.alugames.modelo
 //open class Esta aberta a receber heranças
final class Plano(val tipo: String){

     fun obterValor(aluguel: Aluguel):Double{
         return aluguel.jogo.preco * aluguel.periodo.emDias

     }
}