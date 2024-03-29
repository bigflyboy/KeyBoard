package com.wangzhiyuan.keyborad.action

import com.wangzhiyuan.keyborad.*
import org.jnativehook.mouse.NativeMouseEvent
import java.awt.Dimension
import java.awt.Toolkit

/**
 * @Author: wangzhiyuan
 * @CreateDate: 2021/8/6 12:38 下午
 * @Description: Action行为管理类
 */
object ActionManager {

    val size: Dimension by lazy { Toolkit.getDefaultToolkit().screenSize }

    val miniWidth by lazy { WIDTH / 200 }

    val maxWidth by lazy { WIDTH - miniWidth }

    val miniHeight by lazy { HEIGHT / 100 }

    val maxHeight by lazy { HEIGHT - miniHeight }

    init {
        printlnWithTime("width = ${size.width} height = ${size.height}")
    }

    fun getMouseType(nativeEvent: NativeMouseEvent): Int {
        if (nativeEvent.x < miniWidth || nativeEvent.x > maxWidth || nativeEvent.y < miniHeight || nativeEvent.y > maxHeight) {
            return ACTION_MOUSE_OUTSIZE
        }
        return ACTION_MOUSE
    }

}