package com.wangzhiyuan.keyborad.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * @Author: wangzhiyuan
 * @CreateDate: 2021/8/6 4:43 下午
 * @Description: 主界面
 */

@Composable
fun MainView() {
    var checked = false
    Row {
        Column(Modifier.size(300.dp).fillMaxHeight().padding(start = 20.dp,top = 20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Alfred Sisley", modifier = Modifier.absolutePadding(top = 10.dp, bottom = 10.dp))
            Text("3 minutes ago")
            Checkbox(checked = checked, onCheckedChange = {
                checked = it
            })
        }
        Column(Modifier.size(300.dp).fillMaxHeight().padding(start = 20.dp,top = 20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Alfred Sisley", modifier = Modifier.absolutePadding(top = 10.dp, bottom = 10.dp))
            Text("3 minutes ago")
        }
    }
}