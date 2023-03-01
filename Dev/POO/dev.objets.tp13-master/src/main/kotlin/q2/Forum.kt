package q2

import com.google.gson.JsonParser
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking

class Forum {
    val lesMessages : MutableList<Message>

    init {
        lesMessages = mutableListOf()
    }

    fun publier(message : Message) {
        lesMessages.add(message)
    }

    fun afficher() {
        for (message in lesMessages)
            println(message)
    }

}

