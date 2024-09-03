package stageExtensions

import korlibs.image.format.*
import korlibs.io.file.std.*
import korlibs.korge.view.*
import korlibs.time.*


suspend fun Stage.renderPikachu(cellSize: Double) {
    val spriteMap = resourcesVfs["spritePikachu2.png"].readBitmap()
    val explosionAnimation = SpriteAnimation(
        spriteMap = spriteMap,
        spriteWidth = 111,
        spriteHeight = 119,
        marginTop = 0,
        marginLeft = 0,
        columns = 6,
        rows = 1,
        offsetBetweenColumns = 6,
        offsetBetweenRows = 0
    )

    val explosion = sprite(explosionAnimation) {
        position(views.virtualWidth * 0.72, 50 + cellSize * 7)
    }
    explosion.playAnimationLooped(spriteDisplayTime = 300.milliseconds)
}
