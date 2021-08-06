package com.wangzhiyuan.keyborad

import com.wangzhiyuan.keyborad.action.ActionManager
import com.wangzhiyuan.keyborad.action.CommonAction
import com.wangzhiyuan.keyborad.listener.SimpleNativeKeyListener
import com.wangzhiyuan.keyborad.listener.SimpleNativeMouseListener
import org.jnativehook.GlobalScreen
import org.jnativehook.NativeHookException
import org.jnativehook.keyboard.NativeKeyEvent
import org.jnativehook.mouse.NativeMouseEvent
import java.awt.Robot
import java.util.logging.Level
import java.util.logging.Logger
import kotlin.system.exitProcess

/**
 * @Author: wangzhiyuan
 * @CreateDate: 2021/8/05 7:25 下午
 * @Description: 后台监听事件管理类
 */
object BackGroudListenService {

    private var isInit = false

    private val robot: Robot = Robot()

    private val actionMap: HashMap<Int, CommonAction> = HashMap()

    fun putAction(nativaType: Int, action: CommonAction) {
        actionMap[nativaType] = action
    }

    fun removeAction(type: Int) {
        actionMap.remove(type)
    }

    fun initHook() {
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
        object : SimpleNativeKeyListener() {

            override fun nativeKeyPressed(event: NativeKeyEvent) {
                printlnWithTime("Key Pressed: " + NativeKeyEvent.getKeyText(event.keyCode))
                actionMap[event.keyCode]?.onKeyPressed(robot, event)
            }

            override fun nativeKeyReleased(event: NativeKeyEvent) {
                printlnWithTime("Key Released: " + NativeKeyEvent.getKeyText(event.keyCode))
                actionMap[event.keyCode]?.onKeyReleased(robot, event)
            }

        }
    }

    private val mouseListener by lazy {
        object : SimpleNativeMouseListener() {
            var currentType = ACTION_MOUSE
            override fun nativeMouseMoved(nativeEvent: NativeMouseEvent) {
                val type = ActionManager.getMouseType(nativeEvent)
                if (currentType != type) {
                    currentType = type
                    printlnWithTime("MouseMoved: $currentType")
                }
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

    fun releaseHook() {
        try {
            GlobalScreen.unregisterNativeHook()
        } catch (nativeHookException: NativeHookException) {
            nativeHookException.printStackTrace()
        }
        isInit = false
    }

}