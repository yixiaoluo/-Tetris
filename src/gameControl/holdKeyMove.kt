package gameControl

import korlibs.event.*
import korlibs.korge.input.*
import korlibs.time.*
import kotlin.time.Duration.Companion.milliseconds


fun holdKeyMove(key: Key,
                input: Input,
                isGamePause: Boolean,
                dt: FastDuration
) {
    var counter = 0.0
    val scale = dt / 16.6666.milliseconds

    if (input.keys.pressing(key) && !isGamePause) {
        if (input.keys.justPressed(key)) {
            counter = 0.0
        }
        //can collect the "scale" as time. We can expect the counter to reach 60 every second (+- a few)
        counter += scale
        //I'm waiting for 5 updates before triggering button release
        if (counter > 5) input.keys.triggerKeyEvent(KeyEvent(key = key))
    }
}
