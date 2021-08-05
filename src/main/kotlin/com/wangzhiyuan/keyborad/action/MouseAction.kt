package com.wangzhiyuan.keyborad.action

import org.jnativehook.mouse.NativeMouseEvent
import java.awt.Robot

/**
 * @Author: wangzhiyuan
 * @CreateDate: 2021/8/5 4:41 下午
 * @Description: 鼠标行为基类
 */
interface MouseAction{
    fun mouseMoved(robot: Robot, event: NativeMouseEvent)
}