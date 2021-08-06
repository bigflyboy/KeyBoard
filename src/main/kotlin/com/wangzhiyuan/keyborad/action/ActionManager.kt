package com.wangzhiyuan.keyborad.action

import com.wangzhiyuan.keyborad.ACTION_MOUSE
import com.wangzhiyuan.keyborad.ACTION_MOUSE_OUTSIZE
import org.jnativehook.mouse.NativeMouseEvent
import java.awt.Toolkit

/**
 * @Author: wangzhiyuan
 * @CreateDate: 2021/8/6 12:38 下午
 * @Description: Action行为管理类
 */
object ActionManager {
    val size by lazy { Toolkit.getDefaultToolkit().screenSize }

    val miniWidth by lazy { size.width / 200 }

    val maxWidth by lazy { size.width - miniWidth }

    val miniHeight by lazy { size.height / 100 }

    val maxHeight by lazy { size.height - miniHeight }

    fun getMouseType(nativeEvent: NativeMouseEvent): Int {
        if (nativeEvent.x < miniWidth || nativeEvent.x > maxWidth || nativeEvent.y < miniHeight || nativeEvent.y > maxHeight) {
            return ACTION_MOUSE_OUTSIZE
        }
        return ACTION_MOUSE
    }

}