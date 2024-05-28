package br.com.alugames.modelo

class PlanoAssinatura(
    tipo: String,
    val mensalidade: Double,
    val jogoIncluidos: Int):Plano((tipo)){

    override fun obterValor(aluguel: Aluguel): Double {
        val  totalJogosNoMes = aluguel.gamer.jogosDoMes(aluguel.periodo.dataInicial.monthValue).size+1
         return if(totalJogosNoMes <= jogoIncluidos){
             0.0
        }
        else{
            return  super.obterValor(aluguel)

        }
      }
    }
