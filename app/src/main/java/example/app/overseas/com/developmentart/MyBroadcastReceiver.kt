package example.app.overseas.com.developmentart

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class MyBroadcastReceiver :BroadcastReceiver(){
    override fun onReceive(p0: Context?, p1: Intent?) {
        Log.e("onReceive===","onReceive")

    }
}