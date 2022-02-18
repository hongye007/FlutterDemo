package com.simple.flutterdemo.flutterview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.simple.flutterdemo.APP
import com.simple.flutterdemo.R
import io.flutter.embedding.android.FlutterView

class FlutterViewActivity : AppCompatActivity() {

    private lateinit var flutterViewEngine: FlutterViewEngine

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        flutterViewEngine = (applicationContext as APP).flutterViewEngine
        flutterViewEngine.attachToActivity(this)
        findViewById<View>(R.id.button).setOnClickListener {
            addByFlutterView()
        }
    }

    private fun addByFlutterView() {
        val view = FlutterView(this)
        val lp = FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        findViewById<FrameLayout>(R.id.container).addView(view, lp)
        flutterViewEngine.attachFlutterView(view)
    }

    override fun onDestroy() {
        super.onDestroy()
        flutterViewEngine.detachFlutterView()
        flutterViewEngine.detachActivity()
    }

    // These below aren't used here in this demo but would be needed for Flutter plugins that may
    // consume these events.

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        flutterViewEngine.onRequestPermissionsResult(requestCode, permissions, grantResults)
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        flutterViewEngine.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onUserLeaveHint() {
        flutterViewEngine.onUserLeaveHint()
        super.onUserLeaveHint()
    }
}