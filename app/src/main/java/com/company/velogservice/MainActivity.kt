package com.company.velogservice

import android.Manifest
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import com.company.velogservice.ui.theme.VelogServiceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                0
            )
        }



        setContent {
            VelogServiceTheme {
                // A surface container using the 'background' color from the theme
                Column (
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Button(onClick = {
                        Intent(applicationContext , RunningService::class.java).also {
                            it.action = RunningService.Actions.START.toString()
                            startService(it)
                        }
                    }) {
                        Text("Start run")
                    }

                    Button(onClick = {
                        Intent(applicationContext , RunningService::class.java).also {
                            it.action = RunningService.Actions.STOP.toString()
                            startService(it)
                        }
                    }) {
                        Text("Stop run")
                    }
                }
            }
        }
    }
}

