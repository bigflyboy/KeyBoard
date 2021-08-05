import androidx.compose.desktop.Window
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.wangzhiyuan.keyborad.BackGroudService


fun main() = Window {
    var text by remember { mutableStateOf("Hello, World!") }

    MaterialTheme {
        Checkbox(checked = false,onCheckedChange = {
            System.err.println("Checkbox = $it")
        })
        Button(onClick = {
            text = "王志远"
        }){
            Text(text)
        }
    }

    BackGroudService.startListenKey()

}
