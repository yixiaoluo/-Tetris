package block

import korlibs.image.color.*

fun blockColor(shapeTransformations: BlockType): RGBA {
    return  when(shapeTransformations) {
        BlockType.I -> Colors.LIGHTPINK;
        BlockType.O -> Colors.TOMATO;
        BlockType.T -> Colors.CORNFLOWERBLUE;
        BlockType.S -> Colors.VIOLET;
        BlockType.Z -> Colors.YELLOW;
        BlockType.J -> Colors.LIGHTSEAGREEN;
        BlockType.L -> Colors.PEACHPUFF;
    }
}
