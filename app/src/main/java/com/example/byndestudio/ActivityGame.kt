package com.example.byndestudio

import android.app.AlertDialog
import android.app.Dialog
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.byndestudio.databinding.ActivityGameBinding

lateinit var bClass : ActivityGameBinding

class ActivityGame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bClass = ActivityGameBinding.inflate(layoutInflater)
        setContentView(bClass.root)

        bClass.job1.setOnClickListener() {
            bClass.buyWorkers.visibility = View.VISIBLE
        }
        bClass.job2.setOnClickListener() {
            bClass.buyWorkers.visibility = View.VISIBLE
        }
        bClass.job3.setOnClickListener() {
            bClass.buyWorkers.visibility = View.VISIBLE
        }
        bClass.job4.setOnClickListener() {
            bClass.buyWorkers.visibility = View.VISIBLE
        }
        bClass.job5.setOnClickListener() {
            bClass.buyWorkers.visibility = View.VISIBLE
        }
        bClass.job6.setOnClickListener() {
            bClass.buyWorkers.visibility = View.VISIBLE
        }
        bClass.exitBuyMenu.setOnClickListener() {
            bClass.buyWorkers.visibility = View.INVISIBLE
        }
    }
}