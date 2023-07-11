package tahadeta.example.footgeneralquiz.data

data class Question(
    var idQuestion: Int,
    var titleQuestion: String? = null,
    var idCorrectAnswer: Int? = null,
    var possibleAnswers: List<tahadeta.example.footgeneralquiz.data.PossibleAnswer> = listOf()
)
