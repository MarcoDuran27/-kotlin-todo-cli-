package trivia_preguntas

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

            print("Tu respuesta: ")
            val entrada = readLine()?.trim() ?: ""
            val respuestaUsuario = entrada.toIntOrNull()

            if (respuestaUsuario == null || respuestaUsuario !in 1..4) {
                println("Respuesta inválida. Debías escribir un número del 1 al 4.")
            } else if (respuestaUsuario == pregunta.respuestaCorrecta) {
                println("Correcto.")
                puntaje++
            } else {
                println("Incorrecto. La respuesta correcta era: ${pregunta.respuestaCorrecta}")
            }

            println()
        }

        mostrarResultado(puntaje, preguntas.size)
    }

    private fun mostrarPregunta(pregunta: Pregunta) {
        println("-----------------------------------")
        println("Dificultad: ${pregunta.dificultad}")
        println("${pregunta.id}. ${pregunta.enunciado}")

        pregunta.opciones.forEachIndexed { index, opcion ->
            println("${index + 1}. $opcion")
        }
    }

    private fun mostrarResultado(puntaje: Int, total: Int) {
        val porcentaje = (puntaje * 100) / total

        println("===================================")
        println("              RESULTADO")
        println("===================================")
        println("Puntaje final: $puntaje de $total")
        println("Porcentaje obtenido: $porcentaje%")

        when {
            porcentaje == 100 -> println("Excelente. Contestaste todo correctamente.")
            porcentaje >= 70 -> println("Muy bien. Tienes buen dominio de Kotlin.")
            porcentaje >= 50 -> println("Resultado aceptable. Puedes seguir practicando.")
            else -> println("Necesitas repasar más los conceptos básicos.")
        }
    }
}