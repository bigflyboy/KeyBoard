package com.wangzhiyuan.keyborad

import com.wangzhiyuan.keyborad.action.CancelAction
import com.wangzhiyuan.keyborad.action.PressedAction
import com.wangzhiyuan.keyborad.action.PressedOnceAction
import org.jnativehook.keyboard.NativeKeyEvent
import java.awt.event.KeyEvent
import java.text.SimpleDateFormat


val f = SimpleDateFormat("HH:mm:ss.SSS")

const val isLogger = true

fun printlnWithTime(message: String) {
    if (isLogger) {
        println(f.format(System.currentTimeMillis()) + ": " + message)
    }
}

fun startBackGroudListen() {
    BackGroudListenService.initHook()
    BackGroudListenService.startListenKey()
    BackGroudListenService.startListenMouse()
    BackGroudListenService.putAction(NativeKeyEvent.VC_SPACE, PressedOnceAction(KeyEvent.VK_SPACE, NativeKeyEvent.VC_SPACE))
    BackGroudListenService.putAction(ACTION_MOUSE_OUTSIZE, CancelAction(0, NativeKeyEvent.VC_SPACE))
}

const val ACTION_MOUSE_OUTSIZE: Int = 0xA000
const val ACTION_MOUSE: Int = 0xA0FF

const val WIDTH = 2560
const val HEIGHT = 1440

