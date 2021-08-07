package com.wangzhiyuan.keyborad.action

import com.wangzhiyuan.keyborad.BackGroudListenService
import org.jnativehook.mouse.NativeMouseEvent
import java.awt.Robot

/**
 * @Author: wangzhiyuan
 * @CreateDate: 2021/8/6 2:00 下午
 * @Description:
 */
class CancelAction(systemType: Int, nativeType: Int) : CommonAction(systemType, nativeType) {

    override fun mouseMoved(robot: Robot, event: NativeMouseEvent) {
        BackGroudListenService.actionMap[nativeType]?.cancel(robot)
    }

}