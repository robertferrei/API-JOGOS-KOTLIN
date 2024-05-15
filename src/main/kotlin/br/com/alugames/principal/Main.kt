package org.example.br.com.alugames.principal

import br.com.alugames.servicos.CosnumoApi
import org.example.br.com.alugames.modelo.Jogo
import java.util.Scanner

fun main() {
    val leitura = Scanner(System.`in`) //leitura para buscarmos o id do jogo
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

        if(opcao.equals("s",true)){
            println("insira a descrição que dejesa para o game:")
            val descricaoPersonalizada = leitura.nextLine()
            meuJogo?.descricao = descricaoPersonalizada
        }else{
            meuJogo?.descricao = meuJogo?.titulo
       }
        println(meuJogo)
    }
    //GSON
}