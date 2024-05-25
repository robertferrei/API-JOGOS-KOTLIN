package br.com.alugames.utilitario

import br.com.alugames.modelo.InfoJogoJson
import org.example.br.com.alugames.modelo.Jogo

fun InfoJogoJson.criaJogo(): Jogo{
    return Jogo(this.titulo,this.capa,this.preco,this.descricao)
}