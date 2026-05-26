package trivia_preguntas

data class Pregunta(
    val id: Int,
    val enunciado: String,
    val opciones: List<String>,
    val respuestaCorrecta: Int
)