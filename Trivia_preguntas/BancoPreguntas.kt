fun obtenerPreguntasPorDificultad(dificultad: Dificultad): List<Pregunta> {
    return listaPreguntas.filter { it.dificultad == dificultad }.shuffled()
}
listaPreguntas.add(
    Pregunta(1, "¿Qué palabra clave define una constante en Kotlin?",
        listOf("var", "const val", "val", "let"), 2, Dificultad.FACIL)
)

listaPreguntas.add(
    Pregunta(2, "¿Cómo maneja Kotlin la seguridad contra nulos por defecto?",
        listOf("Permite nulos siempre", "Los tipos no son anulables por defecto", "Usa punteros", "Lanza NullPointerException"),
        2, Dificultad.MEDIA)
)

listaPreguntas.add(
    Pregunta(3, "¿Cuál es la ventaja de una Data Class?",
        listOf("Hereda de múltiples clases", "Genera automáticamente métodos", "Hace el código más rápido", "No permite funciones"),
        2, Dificultad.DIFICIL)
)