package example.app.overseas.com.developmentart

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import android.content.pm.PackageManager
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (findViewById(R.id.sample_text) as TextView).setOnClickListener(View.OnClickListener {
            hiddenStartActivity()
        })
        sample_text.text = stringFromJNI()
    }


    //隐式启动
    fun hiddenStartActivity() {
        var intent = Intent("example.app.overseas.com.developmentart.a");
        intent.addCategory("example.app.overseas.com.developmentart.b");
//            intent.setDataAndType(Uri.parse("file://abc"), "text/plain");
        if (isIntentAvailable(this, intent)) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "空", Toast.LENGTH_LONG).show()
        }
    }
    //启动其他应用指定页面
    /**
     * 需要在打开LoginActivity 设置 android:exported="true"
     */
    fun startOtherApp() {
        var cn = ComponentName("club.ifaonline.app", "club.ifaonline.app.activity.login.LoginActivity");
        var intent = Intent();
        intent.setComponent(cn);
        startActivity(intent);
    }

    fun isIntentAvailable(context: Context, intent: Intent?): Boolean {
        return if (intent == null) {
            false
        } else context.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)!!.size > 0
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
