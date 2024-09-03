package gameControl

import block.*
import BoardCollisionHelper
import BoardOfCells


fun isMoveLegal(blockItem: BlockItem, boardOfCells: BoardOfCells): Boolean {
    var boardHelper = BoardCollisionHelper(boardOfCells)
    val x  = blockItem.location.x
    val y = blockItem.location.y


    return !boardHelper.isBlockHitBottom(blockItem, y.toDouble() ) &&
        !boardHelper.isBlockOverlapping(blockItem, x.toDouble(), y.toDouble()) &&
        boardHelper.isBlockInsideBoard(blockItem)
}

fun canBlockMoveLeft(blockItem: BlockItem, boardOfCells: BoardOfCells): Boolean {
    var blockItemAfterMove =  BlockItem(
        rotationIndex = blockItem.rotationIndex,
        shapeTransformations = blockItem.shapeTransformations,
        location = PointVar(blockItem.location.x -1,blockItem.location.y),
        color = blockItem.color)

    return isMoveLegal(blockItemAfterMove,boardOfCells)
}

fun canBlockMoveRight(blockItem: BlockItem, boardOfCells: BoardOfCells): Boolean {
    var blockItemAfterMove =  BlockItem(
        rotationIndex = blockItem.rotationIndex,
        shapeTransformations = blockItem.shapeTransformations,
        location = PointVar(blockItem.location.x +1,blockItem.location.y),
        color = blockItem.color)
    return isMoveLegal(blockItemAfterMove,boardOfCells)
}

fun canBlockMoveDown(blockItem: BlockItem, boardOfCells: BoardOfCells): Boolean {
    var blockItemAfterMove =  BlockItem(
        rotationIndex = blockItem.rotationIndex,
        shapeTransformations = blockItem.shapeTransformations,
        location = PointVar(blockItem.location.x,blockItem.location.y + 1),
        color = blockItem.color)

    return isMoveLegal(blockItemAfterMove,boardOfCells)
}


fun canBlockRotateCounterClockwise(blockItem: BlockItem, boardOfCells: BoardOfCells): Boolean {
    var blockItemAfterMove =  BlockItem(
        rotationIndex = blockItem.rotationIndex ,
        shapeTransformations = blockItem.shapeTransformations,
        location = PointVar(blockItem.location.x, blockItem.location.y),
        color = blockItem.color)

    blockItemAfterMove.rotateCounterClockwise()
//    println("RotationIndexCountClockWise = ${blockItemAfterMove.rotationIndex}")
    return isMoveLegal(blockItemAfterMove,boardOfCells)
}

fun canBlockRotate(blockItem: BlockItem, newBoardNCol: Int, newBoardNRow: Int): Boolean {
    return (blockItem.location.x + blockItem.shape.height <= newBoardNCol) && (blockItem.location.y + blockItem.shape.width <= newBoardNRow)
}

fun canBlockRotateClockwise(blockItem: BlockItem, boardOfCells: BoardOfCells): Boolean {
    var blockItemAfterMove =  BlockItem(
        rotationIndex = blockItem.rotationIndex ,
        shapeTransformations = blockItem.shapeTransformations,
        location = PointVar(blockItem.location.x, blockItem.location.y),
        color = blockItem.color)
    blockItemAfterMove.rotateClockwise()
//    println("RotationIndexClockWise = ${blockItemAfterMove.rotationIndex}")
    return isMoveLegal(blockItemAfterMove, boardOfCells)
}

fun isInside(x: Int, y: Int, newBoardNCol: Int,newBoardNRow: Int): Boolean = x >= 0 && y >= 0 && x < newBoardNCol && y < newBoardNRow

