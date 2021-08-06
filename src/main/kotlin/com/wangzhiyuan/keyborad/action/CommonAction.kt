package com.wangzhiyuan.keyborad.action

import org.jnativehook.keyboard.NativeKeyEvent
import org.jnativehook.mouse.NativeMouseEvent
import java.awt.Robot

/**
 * @Author: wangzhiyuan
 * @CreateDate: 2021/8/5 4:30 下午
 * @Description: Action 基类
 */
open class CommonAction(val systemType: Int, val nativeType: Int) : KeyAction, MouseAction, ICancel {
    override fun onKeyPressed(robot: Robot, event: NativeKeyEvent) {

    }

    override fun onKeyReleased(robot: Robot, event: NativeKeyEvent) {

    }

    override fun mouseMoved(robot: Robot, event: NativeMouseEvent) {

    }

    override fun cancel() {

    }
}