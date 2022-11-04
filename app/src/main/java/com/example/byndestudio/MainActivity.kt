package com.example.byndestudio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.byndestudio.databinding.ActivityMainBinding

lateinit var bindingClass : ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(s: Bundle?) {
        super.onCreate(s)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
    }
}
