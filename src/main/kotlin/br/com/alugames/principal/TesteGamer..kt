import br.com.alugames.modelo.Gamer

fun main(){
    val gamer1 = Gamer("robert", email = "robert@email.com")

    val gamer2 = Gamer("laurinha", email = "laurinha@email.com", dataNascimento = "15/12/2003", usuario = "lalinha")
    println(gamer2)

gamer1.let {
    it.dataNascimento = "25/09/2004"
    it.usuario = "rozak1v3"
}
    println(gamer1.idInterno)


}