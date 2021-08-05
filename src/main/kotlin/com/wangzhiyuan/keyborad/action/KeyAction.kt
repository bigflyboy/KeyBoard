package com.wangzhiyuan.keyborad.action

import org.jnativehook.keyboard.NativeKeyEvent
import java.awt.Robot

/**
 * @Author: wangzhiyuan
 * @CreateDate: 2021/8/5 4:40 下午
 * @Description: Key行为基类
 */
interface KeyAction {
    fun onKeyPressed(robot: Robot, event: NativeKeyEvent)
    fun onKeyReleased(robot: Robot, event: NativeKeyEvent)
}