import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun String.transformarEmIdade(): Int {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    var idade  = 0
    val dataNascimento = LocalDate.parse(this, formatter) //passando a data de nascimento e formatando
    val hoje = LocalDate.now() //data atual
    idade = Period.between(dataNascimento,hoje).years //calculo para descobrir idade

    return  idade
}
