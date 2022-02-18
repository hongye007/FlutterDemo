package com.simple.flutterdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.simple.flutterdemo.flutterview.FlutterViewActivity
import io.flutter.embedding.android.FlutterActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        findViewById<View>(R.id.single_view).setOnClickListener {
            startActivity(FlutterActivity.withCachedEngine("single").build(this))
        }

        findViewById<View>(R.id.flutter_fragment).setOnClickListener {
            jumpToActivity(FlutterFragmentActivity::class.java)
        }

        findViewById<View>(R.id.flutter_view).setOnClickListener {
            jumpToActivity(FlutterViewActivity::class.java)
        }
    }

    private fun jumpToActivity(clazz: Class<*>) {
        val intent = Intent()
        intent.setClass(this, clazz)
        startActivity(intent)
    }
}