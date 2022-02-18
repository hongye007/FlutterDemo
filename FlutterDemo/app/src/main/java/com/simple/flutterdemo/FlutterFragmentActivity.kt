package com.simple.flutterdemo

import android.content.Intent
import android.os.Bundle
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import io.flutter.embedding.android.FlutterFragment

class FlutterFragmentActivity : FragmentActivity() {

    private var flutterFragment: FlutterFragment? = null
    private val FRAGMENT_TAG = "FLUTTER_FRAGMENT"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flutter_fragment)

        val fragmentManager = supportFragmentManager
        flutterFragment = fragmentManager.findFragmentByTag(FRAGMENT_TAG) as FlutterFragment?

        if (flutterFragment == null) {
            // 创建新的实例, 等价于FlutterFragment.withNewEngine().build<FlutterFragment>()
            // var newFlutterFragment = FlutterFragment.createDefault()
            val newFlutterFragment =
                FlutterFragment.withCachedEngine("single").build<FlutterFragment>()
            flutterFragment = newFlutterFragment
            fragmentManager.beginTransaction().add(R.id.container, newFlutterFragment, FRAGMENT_TAG)
                .commit()
        }
    }

    override fun onPostResume() {
        super.onPostResume()
        flutterFragment!!.onPostResume()
    }

    override fun onNewIntent(@NonNull intent: Intent) {
        super.onNewIntent(intent)
        flutterFragment!!.onNewIntent(intent)
    }

    override fun onBackPressed() {
        flutterFragment!!.onBackPressed()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        flutterFragment!!.onRequestPermissionsResult(
            requestCode,
            permissions,
            grantResults
        )
    }

    override fun onUserLeaveHint() {
        flutterFragment!!.onUserLeaveHint()
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        flutterFragment!!.onTrimMemory(level)
    }
}