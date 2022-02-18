package com.simple.flutterdemo

import android.app.Application
import com.simple.flutterdemo.flutterview.FlutterViewEngine
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor

/**
 *
 * 描述:
 * 时间: 2022/2/17 17:24
 */
class APP : Application() {

    lateinit var flutterEngine: FlutterEngine
    lateinit var flutterViewEngine: FlutterViewEngine

    override fun onCreate() {
        super.onCreate()
        initFlutterEngine()
    }

    fun initFlutterEngine() {
        flutterEngine = FlutterEngine(this)
        flutterEngine.dartExecutor.executeDartEntrypoint(DartExecutor.DartEntrypoint.createDefault())
        flutterEngine.navigationChannel.setInitialRoute("/")

        // 可以通过FlutterEngineCache进行缓存
        FlutterEngineCache.getInstance().put("single", flutterEngine)

        // flutter view 方式使用
        flutterViewEngine = FlutterViewEngine(flutterEngine)
    }
}