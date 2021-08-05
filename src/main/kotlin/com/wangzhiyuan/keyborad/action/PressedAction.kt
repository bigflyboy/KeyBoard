package com.wangzhiyuan.keyborad.action

import kotlinx.coroutines.*
import org.jnativehook.keyboard.NativeKeyEvent
import java.awt.Robot

/**
 * @Author: wangzhiyuan
 * @CreateDate: 2021/8/5 4:53 下午
 * @Description: 按住事件
 */
class PressedAction(systemType: Int, nativeType: Int) : CommonAction(systemType, nativeType) {

    var enable = false

    var pressedJob: Job? = null

    override fun onKeyReleased(robot: Robot, event: NativeKeyEvent) {
        if (enable) {
            pressedJob?.cancel()
        } else {
            pressedJob = CoroutineScope(Dispatchers.IO).launch {
                while (true) {
                    robot.keyPress(systemType)
                    delay(80)
                }
            }
        }
        enable = !enable
    }

}