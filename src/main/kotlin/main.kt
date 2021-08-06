import androidx.compose.desktop.Window
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import com.wangzhiyuan.keyborad.BackGroudListenService
import com.wangzhiyuan.keyborad.action.PressedAction
import com.wangzhiyuan.keyborad.action.PressedOnceAction
import org.jnativehook.keyboard.NativeKeyEvent
import java.awt.event.KeyEvent

fun main() = Window {
    var text by remember { mutableStateOf("Hello, World!") }

    MaterialTheme {
        ArtistCard()
    }

    BackGroudListenService.initHook()
    BackGroudListenService.startListenKey()
    BackGroudListenService.startListenMouse()
    BackGroudListenService.putAction(NativeKeyEvent.VC_SPACE, PressedAction(KeyEvent.VK_SPACE, NativeKeyEvent.VC_SPACE))
    BackGroudListenService.putAction(NativeKeyEvent.VC_ALT, PressedAction(KeyEvent.VK_ALT, NativeKeyEvent.VC_ALT))
}

@Composable
fun ArtistCard() {
    Column {
        Text("Alfred Sisley")
        Text("3 minutes ago")
    }
}