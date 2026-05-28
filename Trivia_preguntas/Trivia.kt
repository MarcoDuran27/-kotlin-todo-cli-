package trivia_preguntas

import kotlin.concurrent.thread

class Trivia {

    private val banco = BancoPreguntas()

    fun iniciar() {
        banco.inicializarTrivia()
        val preguntas = banco.obtenerPreguntasDelJuego()
        var puntaje = 0

        println("===================================")
        println("          TRIVIA DE KOTLIN")
        println("===================================")
        println("Responde escribiendo el número de la opción correcta.")
        println("Total de preguntas: ${banco.contarPreguntas()}")
        println()

        preguntas.forEach { pregunta ->
            mostrarPregunta(pregunta)

            print("Tu respuesta (tienes 10 segundos): ")

            // ⏱ lectura con tiempo límite
            val entrada = leerConTiempo(10)?.trim() ?: ""
            val respuestaUsuario = entrada.toIntOrNull()

            if (respuestaUsuario == pregunta.respuestaCorrecta) {
                println("Correcto")
                puntaje++
            } else {
                if (entrada.isEmpty()) {
                    println("Incorrecto. No respondiste a tiempo.")
                } else {
                    println("Incorrecto. La respuesta correcta era: ${pregunta.respuestaCorrecta}")
                }
            }

            println()
        }

        mostrarResultado(puntaje, preguntas.size)
    }

    private fun mostrarPregunta(pregunta: Pregunta) {
        println("${pregunta.id}. ${pregunta.enunciado}")

        pregunta.opciones.forEachIndexed { index, opcion ->
            println("${index + 1}. $opcion")
        }
    }

    private fun mostrarResultado(puntaje: Int, total: Int) {
        println("===================================")
        println("              RESULTADO")
        println("===================================")
        println("Puntaje final: $puntaje de $total")

        when {
            puntaje == total ->
                println("Excelente. Contestaste todo correctamente.")
            puntaje >= total / 2 ->
                println("Buen resultado. Vas entendiendo Kotlin.")
            else ->
                println("Necesitas repasar más los conceptos básicos.")
        }
    }
}

/* =========================================
   ⏱ FUNCIÓN CON TIEMPO LÍMITE
   ========================================= */

fun leerConTiempo(segundos: Int): String? {
    var respuesta: String? = null

    val hilo = thread {
        respuesta = readLine()
    }

    for (i in segundos downTo 1) {
        print("\rTiempo restante: $i segundos ")
        Thread.sleep(1000)
        if (!hilo.isAlive) break
    }

    if (hilo.isAlive) {
        hilo.interrupt()
        println("\nTiempo agotado")
    }

    return respuesta
}