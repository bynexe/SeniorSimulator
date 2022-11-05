package com.example.byndestudio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.byndestudio.databinding.ActivityMainBinding
import kotlin.system.exitProcess

lateinit var bindingClass : ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(s: Bundle?) {
        super.onCreate(s)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        bindingClass.bStartGame.setOnClickListener {
            val intent = Intent(this, ActivityGame::class.java)
            startActivity(intent)
        }

        bindingClass.bExit.setOnClickListener() {
            moveTaskToBack(true)
            exitProcess(1)
        }
    }
}
