fun getHighestScore(scoreIn: Int): String {

    val fileName = "resources/highestScore.txt"
    val scoreString = mutableListOf<Int>(0)
    scoreString.add(scoreIn)
    val maxScore = scoreString.max().toString()
    return maxScore
}
