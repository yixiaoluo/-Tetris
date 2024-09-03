package stageExtensions

import korlibs.image.color.*
import korlibs.korge.view.*
import korlibs.korge.view.align.*

fun Stage.updateGameScore(score: Int, cellSize:Double) {
    text(score.toString(), cellSize * 0.5, Colors.BLUE) {
        centerXBetween(views.virtualWidth * 0.75, views.virtualWidth * 0.85)
        centerYBetween(65 + cellSize * 15, 65 + cellSize * 17)
        color = Colors.DARKGREEN
    }
}
