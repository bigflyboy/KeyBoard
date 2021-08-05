package com.wangzhiyuan.keyborad

import com.wangzhiyuan.keyborad.listener.SimpleNativeKeyListener
import com.wangzhiyuan.keyborad.listener.SimpleNativeMouseListener
import org.jnativehook.GlobalScreen
import org.jnativehook.NativeHookException
import org.jnativehook.keyboard.NativeKeyEvent
import org.jnativehook.mouse.NativeMouseEvent
import java.util.logging.Level
import java.util.logging.Logger
import kotlin.system.exitProcess

/**
 * @Author: wangzhiyuan
 * @CreateDate: 2021/8/05 7:25 下午
 * @Description: 监控键盘鼠标事件
 */
object BackGroudService {

    private var isInit = false

    fun initHook(){
        try {
            GlobalScreen.registerNativeHook()
        } catch (ex: NativeHookException) {
            System.err.println("There was a problem registering the native hook.")
            System.err.println(ex.message)
            exitProcess(1)
        }
        isInit = true
        val logger: Logger = Logger.getLogger(GlobalScreen::class.java.getPackage().name)
        logger.level = Level.WARNING
        logger.useParentHandlers = false
    }

    private val keyListener by lazy {
        object: SimpleNativeKeyListener() {

            override fun nativeKeyPressed(event: NativeKeyEvent) {
                printlnWithTime("Key Pressed: " + NativeKeyEvent.getKeyText(event.keyCode))
            }

            override fun nativeKeyReleased(event: NativeKeyEvent) {
                printlnWithTime("Key Released: " + NativeKeyEvent.getKeyText(event.keyCode))
            }

        }
    }

    private val mouseListener by lazy {
        object :SimpleNativeMouseListener(){
            override fun nativeMouseMoved(nativeEvent: NativeMouseEvent) {
                printlnWithTime("MouseMoved: " + nativeEvent.point)
            }
        }
    }

    fun startListenKey() {
        GlobalScreen.addNativeKeyListener(keyListener)
    }

    fun stopListenKey() {
        GlobalScreen.removeNativeKeyListener(keyListener)
    }

    fun startListenMouse() {
        GlobalScreen.addNativeMouseMotionListener(mouseListener)
    }

    fun stopListenMouse() {
        GlobalScreen.removeNativeMouseMotionListener(mouseListener)
    }

    fun releaseHook(){
        try {
            GlobalScreen.unregisterNativeHook()
        } catch (nativeHookException: NativeHookException) {
            nativeHookException.printStackTrace()
        }
        isInit = false
    }

}