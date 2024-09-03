//package gameControl
//
//import BlockItem
//import korlibs.korge.view.*
//
//fun Stage.createNewBlock(newBlockItem: BlockItem,
//                      cellSize:Double,
//                      leftIndent: Double,
//                      topIndent: Double,
//                      isGamePause: Boolean): Graphics {
//    val blockItemGraph = graphics {
//        fill(newBlockItem.color) {
//            newBlockItem.shape.getPositionsWithValue(true).forEach { (x, y) ->
//                rect(10 + (1 + cellSize) * x, 15 + (1 + cellSize) * y, cellSize, cellSize)
//            }
//        }
//    }.position(
//        leftIndent + newBlockItem.location.x * (1 + cellSize),
//        topIndent + newBlockItem.location.y * (1 + cellSize)
//    )
//
//    return blockItemGraph
//}
