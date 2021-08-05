package com.wangzhiyuan.keyborad

import org.jnativehook.GlobalScreen
import org.jnativehook.NativeHookException
import org.jnativehook.keyboard.NativeKeyEvent
import org.jnativehook.keyboard.NativeKeyListener
import java.util.logging.Level
import java.util.logging.Logger
import kotlin.system.exitProcess

/**
 * @Author: wangzhiyuan
 * @CreateDate: 2021/8/05 7:25 下午
 * @Description: 监控键盘鼠标事件
 */
object BackGroudService {

    init {
        try {
            GlobalScreen.registerNativeHook()
        } catch (ex: NativeHookException) {
            System.err.println("There was a problem registering the native hook.")
            System.err.println(ex.message)
            exitProcess(1)
        }
        val logger: Logger = Logger.getLogger(GlobalScreen::class.java.getPackage().name)
        logger.level = Level.WARNING
        logger.useParentHandlers = false
    }

    fun startListenKey() {
        GlobalScreen.addNativeKeyListener(object: NativeKeyListener {
            override fun nativeKeyTyped(e: NativeKeyEvent) {

            }

            override fun nativeKeyPressed(e: NativeKeyEvent) {
                printlnWithTime("Key Pressed: " + NativeKeyEvent.getKeyText(e.keyCode))
                if (e.keyCode == NativeKeyEvent.VC_ESCAPE) {
                    try {
                        GlobalScreen.unregisterNativeHook()
                    } catch (nativeHookException: NativeHookException) {
                        nativeHookException.printStackTrace()
                    }
                }
            }

            override fun nativeKeyReleased(e: NativeKeyEvent) {
                printlnWithTime("Key Released: " + NativeKeyEvent.getKeyText(e.keyCode))
            }

        })
    }

    fun stopListenKey() {

    }

    fun startListenMouse() {

    }

    fun stopListenMouse() {

    }

}