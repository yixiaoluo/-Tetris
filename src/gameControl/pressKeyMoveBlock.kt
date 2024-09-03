package gameControl

import block.*
import BoardOfCells

import korlibs.event.*
import korlibs.korge.input.*

fun pressKeyMoveBlock(key: Key,
                      input: Input,
                      currentBlockItem: BlockItem,
                      isGamePause: Boolean,
                      bgBoardOfCells: BoardOfCells): BlockItem {
//    val boardHelper = BoardCollisionHelper(bgBoardOfCells)

    when (key) {
        Key.LEFT -> if (input.keys.justPressed(key) && canBlockMoveLeft(currentBlockItem, bgBoardOfCells) && !isGamePause){
            currentBlockItem.location.x -= 1
        }


        Key.RIGHT -> if (input.keys.justPressed(key) && canBlockMoveRight(currentBlockItem, bgBoardOfCells)&& !isGamePause)
        {
            currentBlockItem.location.x += 1
        }


        Key.DOWN -> if (input.keys.justPressed(key)&& canBlockMoveDown(currentBlockItem, bgBoardOfCells)&& !isGamePause)
        {
            currentBlockItem.location.y += 1
        }

        Key.SPACE -> if (input.keys.justPressed(key) && !isGamePause){
            while(canBlockMoveDown(currentBlockItem, bgBoardOfCells)){
                currentBlockItem.location.y += 1
            }
        }



        Key.Q -> if (input.keys.justPressed(key) &&
            canBlockRotateCounterClockwise(currentBlockItem, bgBoardOfCells) && !isGamePause) {
            currentBlockItem.rotateCounterClockwise()
        }



        Key.E -> if (input.keys.justPressed(key) &&
            canBlockRotateClockwise(currentBlockItem,bgBoardOfCells) && !isGamePause) {
            currentBlockItem.rotateClockwise()
        }

        else ->  currentBlockItem.location.x
    }

    var rotationIndex = currentBlockItem.rotationIndex
    if (rotationIndex != currentBlockItem.rotationIndex && !isGamePause) {
//                clear()
//                drawShape(newBlockItem, cellSize)
        rotationIndex = currentBlockItem.rotationIndex
    }
    return currentBlockItem
}
