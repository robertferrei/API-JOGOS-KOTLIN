package br.com.alugames.servicos

import br.com.alugames.modelo.Gamer
import br.com.alugames.modelo.InfoGAMERJSON
import br.com.alugames.utilitario.criaGamer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.example.br.com.alugames.modelo.InfoJogo
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class CosnumoApi {
//criando função para consumir dados
    private fun consumoDadosApi(endereco: String):String{

        val client: HttpClient = HttpClient.newHttpClient()  //requisição
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()

        val response = client //resposta
            .send(request, BodyHandlers.ofString())
        return response.body()

    }
    fun buscaJogo(id: String): InfoJogo {
        val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"
        val  json = consumoDadosApi(endereco)

        //pegando o corpo da API para minha requisição
        val gsonn = Gson()
        val meuInfoJogo = gsonn.fromJson(json, InfoJogo::class.java) //passando nosso corpo e passando a classe
        return meuInfoJogo
    }
//busca gameer

    fun buscaGamer(): List<Gamer> {
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"
        val json = consumoDadosApi(endereco)

        //pegando o corpo da API para minha requisição

        val gsonn = Gson()
        val meuGamerTipo = object: TypeToken<List<InfoGAMERJSON>>() {}.type //esse método ajuda a identificar o tipo para nosso json
        val listaGamer: List<InfoGAMERJSON> = gsonn.fromJson(json, meuGamerTipo) //passando nosso corpo  e passando a lista para declaração

        val listaGamerConvertida = listaGamer.map { infoGAMERJSON -> infoGAMERJSON.criaGamer()} //mapeando os dados do gamer
        return listaGamerConvertida

    }
}