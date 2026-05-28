package trivia_preguntas

enum class Dificultad {
    FACIL, MEDIA, DIFICIL
}

enum class Dificultad {
    FACIL,
    MEDIA,
    DIFICIL
}

data class Pregunta(
    val id: Int,
    val enunciado: String,
    val opciones: List<String>,
    val respuestaCorrecta: Int,
    val dificultad: Dificultad
)