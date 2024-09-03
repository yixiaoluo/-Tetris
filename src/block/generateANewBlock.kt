package block

import kotlin.random.*

fun generateANewBlock(): BlockItem {
    val newBlockLocationX = 3.0
    val newBlockLocationY = 0.0
    val newBlockIndexType = Random.nextInt(7)
    val newBlockLocation = PointVar(x = newBlockLocationX, y =newBlockLocationY)
    val blockShape = when(newBlockIndexType) {
        0 -> BlockType.I;
        1 -> BlockType.O;
        2 -> BlockType.T;
        3 -> BlockType.S;
        4 -> BlockType.Z;
        5 -> BlockType.J;
        6 -> BlockType.L;
        else -> BlockType.I;
    }
    val color = blockColor(blockShape)
    return BlockItem(0, blockShape.shapes, newBlockLocation,color);
}
