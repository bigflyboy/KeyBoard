import androidx.compose.desktop.Window
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.wangzhiyuan.keyborad.printlnWithTime
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.awt.Robot
import java.awt.event.KeyEvent
import org.jnativehook.keyboard.NativeKeyEvent

import org.jnativehook.NativeHookException

import org.jnativehook.GlobalScreen
import org.jnativehook.keyboard.NativeKeyListener
import java.util.logging.Level
import java.util.logging.Logger
import kotlin.system.exitProcess


fun main() = Window {
    var text by remember { mutableStateOf("Hello, World!") }
    var robot = Robot()

    MaterialTheme {
        Button(onClick = {
            text = "Hello, Desktop!"
            CoroutineScope(Dispatchers.Default).launch {
                var count = 100
                while (count>0){
                    count --
                    keyPress(robot, KeyEvent.VK_SPACE)
                }
            }
        }) {
            Text(text)
        }
    }

    BackGroundService.startListenKey()

}

fun keyPress(robot: Robot, key:Int){
    robot.keyPress(key)
    robot.delay(1000)
    robot.keyRelease(key)
}