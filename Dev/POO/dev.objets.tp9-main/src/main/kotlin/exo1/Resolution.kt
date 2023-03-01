package iut.exo1

import java.net.InetAddress
import java.net.UnknownHostException

fun main() {
    try {
        print("Saisir un nom :")
        val nom = readln()
        val ip = nomVersIP(nom)
        println("IP correspondante :$ip")
    }
    catch (e: UnknownHostException){
        println("$e")
    }

}


fun nomVersIP(nom : String) : String {
    return InetAddress.getByName(nom).hostAddress
}