package com.example.byndestudio

import android.app.AlertDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.byndestudio.databinding.ActivityGameBinding

lateinit var bClass : ActivityGameBinding

class ActivityGame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bClass = ActivityGameBinding.inflate(layoutInflater)
        setContentView(bClass.root)

        bClass.job1.setOnClickListener() {
        }
    }
}