fun main() { // ktlint-disable filename
    println("Bem vindo ao Bytebank")

    val contaTania = Conta(titular = "Tania",1000)
    contaTania.deposita(valor= 200.0)

    val contaFran = Conta("Fran",1001)
    contaFran.deposita(valor=300.0)


    println(contaTania.titular)
    println(contaTania.numero)
    println(contaTania.saldo)

    println(contaFran.titular)
    println(contaFran.numero)
    println(contaFran.saldo)

    println("depositando na conta Tania")
    contaTania.deposita(valor = 50.0)
    println(contaTania.saldo)

    println("depositando na conta Fran")
    contaFran.deposita(valor = 70.0)
    println(contaFran.saldo)

    println("sacando na conta Tania")
    contaTania.saca(valor = 250.0)
    println(contaTania.saldo)

    println("sacando na conta da Fran")
    contaFran.saca(valor = 100.0)
    println(contaFran.saldo)

    println("saque em excesso na conta do Tania")
    contaTania.saca(valor = 100.0)
    println(contaTania.saldo)

    println("Saque em execesso na conta da Fran")
    contaFran.saca(valor = 500.0)
    println(contaFran.saldo)

    println("Transferência da conta Tania para Fran")

    if(contaFran.transfere(valor = 300.0,contaTania)){
        println("Transferência sucedida")
    } else{
        println("Falhar na transferência")
    }

    println(contaTania.saldo)
    println(contaFran.saldo)

}

class Conta(
    var titular: String,
    val numero: Int

    )
{
    var saldo = 0.0
        private set

    fun deposita(valor: Double){
        if(valor > 0) {
            this.saldo += valor
        }
    }

    fun saca(valor: Double){
        if(saldo>= valor)
            saldo -= valor

    }

    fun transfere(valor: Double, destino: Conta): Boolean{
        if(saldo >= valor) {
            saldo -= valor
            destino.deposita(valor)
            return true
        }
        return false
    }

}

fun testaCopiasEReferencias(){
    val numeroX = 10
    var numeroY = numeroX
    numeroY++

    println("numeroX $numeroX")
    println("numeroY $numeroY")

    val contaJoao = Conta("João", 1002)
    contaJoao.titular = "João"
    var contaLucas = Conta(titular = "Lucas", 1003)
    contaLucas.titular = "Lucas"
    contaJoao.titular= "João"

    println("titular conta lucas:${contaLucas.titular}")
    println("titular conta Joao: ${contaJoao.titular}")

}

fun testaLacos(){
    var i = 0
    while(i < 5 ){
        val titular: String = "Tania $i"
        val numerodaconta: Int = 1000 + i
        var saldo = i + 10.0

        println("titular $titular")
        println("número da conra $numerodaconta")
        println("saldo da conta $saldo")
        println()
        i++

    }

    for (i in 5 downTo 1){
        val titular: String = "Tania $i"
        val numerodaconta: Int = 1000 + i
        var saldo = i + 10.0

        println("titular $titular")
        println("número da conra $numerodaconta")
        println("saldo da conta $saldo")
        println()

    }

}

fun testarCondicoes(saldo: Double){
    if (saldo > 0.0){
        println("conta é positiva")
    }else if (saldo == 0.0){
        println("conta é neutra")
    }else {
        println("conta é neutra")
    }

    when {
        saldo > 0.0 ->  println("conta é positiva")
        saldo == 0.0 -> println("conta é neutra")
        else -> println(" conta é negativa")

    }

}


