package br.com.alugames.utilitario

import br.com.alugames.modelo.Gamer
import br.com.alugames.modelo.InfoGAMERJSON

//se tiver InfoGAMERJSON e chamar a criagamer vai transformar em um objeto tipo Gamer
// ----> CONSUMOAPI
fun  InfoGAMERJSON.criaGamer(): Gamer{
    return  Gamer(this.nome,this.email,this.dataNascimento,this.usuario)//mapeando os dados do gamer
}