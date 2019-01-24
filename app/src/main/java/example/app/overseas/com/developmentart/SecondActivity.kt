package example.app.overseas.com.developmentart

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        (findViewById(R.id.tv_second) as TextView).setOnClickListener(View.OnClickListener {
            var intent = Intent(SecondActivity@ this, ThirdActivity::class.java)
//            使用flags设置新栈解决 ApplicationContext启动startActivity 报错问题
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        })

    }
}