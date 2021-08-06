package com.wangzhiyuan.keyborad

import java.text.SimpleDateFormat


val f = SimpleDateFormat("HH:mm:ss.SSS")

const val isLogger = true

fun printlnWithTime(message: String) {
    if (isLogger) {
        println(f.format(System.currentTimeMillis()) + ": " + message)
    }
}

const val ACTION_MOUSE_OUTSIZE: Int = 0xA000
const val ACTION_MOUSE: Int = 0xA0FF