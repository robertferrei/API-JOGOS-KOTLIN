package br.com.alugames.servicos

import com.google.gson.Gson
import org.example.br.com.alugames.modelo.InfoJogo
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class CosnumoApi {
    fun buscaJogo(id: String):InfoJogo {
    val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"

    val client: HttpClient = HttpClient.newHttpClient()  //requisição
    val request = HttpRequest.newBuilder()
        .uri(URI.create(endereco))
        .build()

    val response = client //resposta
        .send(request, BodyHandlers.ofString())
    val json = response.body()

    //pegando o corpo da API para minha requisição
    val gsonn = Gson()
    val meuInfoJogo = gsonn.fromJson(json, InfoJogo::class.java) //passando nosso corpo e passando a classe
        return meuInfoJogo
}
}