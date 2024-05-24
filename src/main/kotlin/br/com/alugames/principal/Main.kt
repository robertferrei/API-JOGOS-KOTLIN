package org.example.br.com.alugames.principal

import br.com.alugames.modelo.Gamer
import br.com.alugames.servicos.CosnumoApi
import org.example.br.com.alugames.modelo.Jogo
import transformarEmIdade
import java.util.Scanner

fun main() {
    val leitura = Scanner(System.`in`) //leitura para buscarmos o id do jogo
    val gamer = Gamer.criarGAMER(leitura)
    print("cadastro concluido com sucesso. Dados do gamer")
    println(gamer)
    println("idade do gamer: ${gamer.dataNascimento?.transformarEmIdade()}")

    do {
        print("Digite o código do jogo para buscar: ")
        val busca = leitura.nextLine() //lendo linha inteira
        var meuJogo: Jogo? = null //declarando que meu jogo pode ser null passando o "?"

        val buscaApi = CosnumoApi()
        val informacaoJogo = buscaApi.buscaJogo(busca)

        //ccriando um jogo e tratando
        val resultado = runCatching { // tratando os dados
            meuJogo = Jogo(informacaoJogo.info.title, informacaoJogo.info.thumb)
        }
        resultado.onFailure {
            println("jogo inexistente tente outro id")
        }
        resultado.onSuccess{
            println("deseja inserir um descrição personalizada ? S/N")
            val opcao = leitura.nextLine()

            //descrição para o game
            if(opcao.equals("s",true)){
                println("insira a descrição que dejesa para o game:")
                val descricaoPersonalizada = leitura.nextLine()
                meuJogo?.descricao = descricaoPersonalizada
            }else{
                meuJogo?.descricao = meuJogo?.titulo
            }
            gamer.jogosBuscados.add(meuJogo) //adicionando meus jogos
        }
        println("deseja estar buscando um novo jogo? S/N")
        val resposta = leitura.nextLine()
        //GSON
    }while (resposta.equals("s", ignoreCase = true))
        println("jogos buscados")
        println(gamer.jogosBuscados)

        print("\n jogos ordenados por titulo:")
    gamer.jogosBuscados.sortBy {
        it?.titulo
    }
    gamer.jogosBuscados.forEach{
        println("titulo:" + it?.titulo) //exibindo os titulos
    }
        println("busca finalizada com sucesso")
    val jogosFiltrados = gamer.jogosBuscados.filter{  //filtrando jogos
        it?.titulo?.contains("batman", ignoreCase = true)?: false

    }
    print("\njogos filtrados: ${jogosFiltrados}")
    println("\ndeseja excluir algum jogo da lista original ?  S/N")

    val opcao = leitura.nextLine()
    if (opcao.equals("s",ignoreCase = true)){
        println("\nLista atualizada: ${gamer.jogosBuscados}")
        println("informe a posição do jogo que deseja excluir")

        val posicao = leitura.nextInt()
        gamer.jogosBuscados.removeAt(posicao) //removeAt removendo por posição
    }
    println("\nLista atualizada: ${gamer.jogosBuscados}")
}