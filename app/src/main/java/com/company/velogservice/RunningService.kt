package com.company.velogservice

import android.app.Service
import android.content.ComponentName
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat

class RunningService : Service() {
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when(intent?.action) {
            Actions.START.toString() -> start()
            Actions.STOP.toString() -> stopSelf()
        }

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
        // return null을 한 이유는 서비스가 바인드를 통해서 클라이언트와 상호작용을 하지 않을 것이며,
        // 오직 startService(Intent)를 통해 시작되어 백그라운드에서 독립적으로 작업을 수행하는 서비스임을 나타내는 것이야.
        // 클라이언트가 서비스와 직접적으로 통신하여 서비스의 메서드를 호출할 필요가 없을 때 이 방식을 사용한다.

        // 서비스로 수행 할 수 있는 작업은 하나의 활성 인스턴스와 여러 구성 요소를 해당 단일 인스턴스에 연결하고
        // 해당 서비스와 통신하고 수신하기 위한 통신을 위한 스트림을 수행 하는 것이다
    }


    private fun start() {
        val notification = NotificationCompat.Builder(this , "running_channel")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("포그라운드 서비스 시작")
            .setContentText("자고 싶다...")
            .build()


        // startForeground()는 ID와 Notification이 필요하다.
        startForeground(1, notification)
    }

    enum class Actions {
        START , STOP
    }
}