package com.fengzhi.mykotlindemo.base

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import java.util.*

object appManager : AppManager {
    object activityStack : Stack<Activity>()

    var count = 0

    fun addActivity(activity: Activity) {
        activityStack.add(activity)
        count++
    }

    fun currentActivity(): Activity {
        return activityStack.lastElement()
    }

    fun finishActivity(activity: Activity) {
        activityStack.remove(activity)
        activity.finish()
        count--
    }

    fun finishAllActivity() {
        var i = 0
        val size = activityStack.size
        while (i < size) {
            if (null != activityStack[i]) {
                activityStack[i].finish()
            }
            i++
        }
        activityStack.clear()
        count = 0
    }

    fun AppExit(context: Context) {
        finishAllActivity()
        var activityMgr = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        activityMgr.restartPackage(context.packageName)
        System.exit(0)
    }
    fun removeActivityFromStack(activity: Activity) {
        activityStack.remove(activity)
    }
}

interface AppManager {
}
