package com.wangzhiyuan.keyborad.action

import org.jnativehook.keyboard.NativeKeyEvent
import java.awt.Robot

/**
 * @Author: wangzhiyuan
 * @CreateDate: 2021/8/5 4:53 下午
 * @Description: 按住事件
 */
class PressedOnceAction(systemType: Int, nativeType: Int) : CommonAction(systemType, nativeType) {

    var enable = false

    override fun onKeyReleased(robot: Robot, event: NativeKeyEvent) {
        if (!enable) {
            robot.keyPress(systemType)
        }
        enable = !enable
    }

    override fun cancel() {
        enable = false
    }

}