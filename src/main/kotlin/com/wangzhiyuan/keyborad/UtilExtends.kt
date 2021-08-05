package com.wangzhiyuan.keyborad

import java.text.SimpleDateFormat


val f = SimpleDateFormat("HH:mm:ss.SSS")

fun printlnWithTime(message: String) {
    println(f.format(System.currentTimeMillis()) + ": " + message)
}

const val ACTION_MOUSE: Int = 0xA000