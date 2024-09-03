import block.*
import board.*
import gameControl.*
import graphicsExtension.*
import korlibs.image.color.*
import korlibs.korge.*
import korlibs.korge.scene.*
import korlibs.korge.view.*
import korlibs.korge.view.align.*
import korlibs.math.geom.*
import stageExtensions.*
import kotlin.time.Duration.Companion.milliseconds

suspend fun main() = Korge(windowSize = Size(600, 800),
    backgroundColor = Colors.DARKSEAGREEN) {
    val sceneContainer = sceneContainer()

    sceneContainer.changeTo { MyScene() }
}

var startNewGame = false
var isGamePause = false
var isGameOver = false
var gameScore = 10000
var stackCount = 0



class MyScene : Scene() {
    var cellSize = 0.0
    val newBoardNRow: Int = 20
    val newBoardNCol: Int = 10
    val newBoardOfCells = createBoardOfCells(width = newBoardNCol,height = newBoardNRow)
    var boardWidth = 0.0
    var boardHeight = 0.0
    var leftIndent = 0.0
    var topIndent = 50.0


    override suspend fun SContainer.sceneMain() {
        val input = views.input
        boardWidth = views.virtualWidth * 0.6
        cellSize = boardWidth / (newBoardNCol + 1)
        boardHeight = 50.0 + newBoardNRow * cellSize
        leftIndent = views.virtualWidth * 0.05


        topIndent = 50.0


        val boardField = roundRect(
            size = Size(width = boardWidth, height = boardHeight),
            radius = RectCorners(10.0, 10.0, 10.0, 10.0),
            fill = Colors.BEIGE,
            autoScaling = true
        ) {
            position(leftIndent, topIndent)
        }

        var nextBlockItem: BlockItem = generateANewBlock()

        addChild(boardField)
        this.stage!!.renderNextBlockContainer(cellSize, nextBlockItem)
        this.stage!!.renderPikachu(cellSize =cellSize)
        var stackRowsCountText = this.stage!!.renderStackRows(cellSize =cellSize)
        val scoreText = this.stage!!.renderScore(cellSize =cellSize)
        val highestScoreText = this.stage!!.renderHighestScore(cellSize =cellSize)
        this.stage!!.renderPauseButton(cellSize =cellSize)
        this.stage!!.renderResumeButton(cellSize =cellSize)


        var isThisBlockDone = false
        var bgBoardOfCells = newBoardOfCells
        var boardHelper = BoardCollisionHelper(bgBoardOfCells)


//        plot background board
//        var boardOfCellsGraph = graphics().drawBgBoardOfCells(bgBoardOfCells,cellSize, leftIndent,topIndent)


//        ----- create a new block
        var newBlockItem = generateANewBlock()
        var rotationIndex = newBlockItem.rotationIndex
        var gravityCounter = 0.0
        var gravityRate = 30
        var gravityThreshold = 60.0


        var currentBlock = this.stage!!.controlCurrentBlock(
            newBlockItem = newBlockItem,
            input = input,
            cellSize = cellSize,
            leftIndent = leftIndent,
            topIndent = topIndent,
            isGamePause = isGamePause,
            bgBoardOfCells = bgBoardOfCells
        )

        var boardOfCellsGraph = graphics().drawBgBoardOfCells(bgBoardOfCells,cellSize, leftIndent,topIndent)

        this.stage!!.addFastUpdater { dt ->
            if (startNewGame) {
                println("startNewGame")
                gameScore = 0
                stackRowsCountText.text = stackCount.toString()
                scoreText.text = gameScore.toString()
                highestScoreText.text = getHighestScore(gameScore)
//                scoreDisplay.text = gameScore.toString()
//                updateGameScore(score=gameScore, cellSize=cellSize)
//                boardOfCellsGraph.clear()
                boardOfCellsGraph.removeFromParent()
                boardOfCellsGraph = graphics().drawBgBoardOfCells(bgBoardOfCells,cellSize, leftIndent,topIndent)
                currentBlock.removeFromParent()
                boardHelper.clearWholeBoard()
                bgBoardOfCells = newBoardOfCells
                boardOfCellsGraph.drawBoardOfCells(bgBoardOfCells, cellSize)
//                currentBlock = createBlock(currentBlockItem, input)
                stackCount = boardHelper.countStacks()
                stackRowsCountText.text = stackCount.toString()


                isGamePause = false
                isGameOver = false
                startNewGame = false
            }

//            updateGameScore(score=gameScore, cellSize=cellSize)
            val scale = dt / 16.6666.milliseconds
            gravityCounter += gravityRate * scale

            if (gravityCounter > gravityThreshold && !isGamePause) {
                gravityCounter = 0.0
                val x = newBlockItem.location.x
                val y = newBlockItem.location.y

                if (!boardHelper.isBlockHitBottom(newBlockItem, y + 1) &&
                    !boardHelper.isBlockOverlapping(newBlockItem, x, y + 1)
                ) {
                    newBlockItem.location.y += 1
                } else {
                    /* block hit bottom:*/
                    bgBoardOfCells = placeBlockItemOnBoardOfCells(
                        blockItem = newBlockItem,
                        bgBoardOfCells = bgBoardOfCells
                    )

                    boardOfCellsGraph.drawBoardOfCells(bgBoardOfCells, cellSize)


                    currentBlock.removeFromParent()
//                    nextBlockItemGraph.removeFromParent()
                    newBlockItem = nextBlockItem
                    nextBlockItem = generateANewBlock()
                    this.stage!!.renderNextBlockContainer(cellSize, nextBlockItem)
                    currentBlock = createNewBlock(
                        blockItem = newBlockItem,
                        cellSize = cellSize,
                        leftIndent= leftIndent,
                        topIndent = topIndent)

//                nextBlockItemGraph = graphics {
//                    position( views.virtualWidth * 0.7-10,   cellSize+50.0-15)
//                    drawShape(nextBlockItem, cellSize)
//                }
//
//
                    stackCount = boardHelper.countStacks()
                    stackRowsCountText.text = stackCount.toString()

//            get complete rows list
                val completeRows = boardHelper.boardCompleteChecker()
                gameScore = maxOf(gameScore, boardHelper.completeRowsN())

                if(completeRows.isNotEmpty()) {
//                    boardOfCellsGraph.clear()
                    boardHelper.clearCompleteRows()
                    boardOfCellsGraph.drawBoardOfCells(bgBoardOfCells, cellSize)
//                    scoreDisplay.text = gameScore.toString()

                }

//                if game Over
                if(stackCount >= newBoardNRow)  isGameOver = true

                if(isGameOver){
                    isGamePause = true
                    highestScoreText.text = getHighestScore(gameScore)
                    showGameOver(cellSize)
                    println("game Over!")
                }

                }

            }
        }

    }
}

