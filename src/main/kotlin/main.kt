import androidx.compose.desktop.Window
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.wangzhiyuan.keyborad.ACTION_MOUSE_OUTSIZE
import com.wangzhiyuan.keyborad.BackGroudListenService
import com.wangzhiyuan.keyborad.action.CancelAction
import com.wangzhiyuan.keyborad.action.PressedAction
import com.wangzhiyuan.keyborad.startBackGroudListen
import com.wangzhiyuan.keyborad.view.MainView
import org.jnativehook.keyboard.NativeKeyEvent
import java.awt.event.KeyEvent

fun main() = Window {

    MaterialTheme {
        MainView()
    }

    startBackGroudListen()
}




