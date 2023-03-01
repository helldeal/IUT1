package q2

import com.google.gson.Gson
import com.google.gson.JsonParser
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking
import java.io.FileReader
import java.io.FileWriter
import java.io.IOException

class Message (titre :String, contenu : String) {

    private val titre : String
    private val contenu : String

    init {
        this.titre  = titre
        this.contenu = contenu
    }

    @Override
    override fun toString(): String {
        return "\n-------\n$titre\n-------\n$contenu"
    }

    fun serialiser(nomFichier : String) {
        TODO()
    }
}

fun deserialiserMessage(nomFichier : String) : Message? {
    TODO()
}


