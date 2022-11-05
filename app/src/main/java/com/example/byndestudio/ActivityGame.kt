package com.example.byndestudio

import android.app.AlertDialog
import android.app.Dialog
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.byndestudio.databinding.ActivityGameBinding
import kotlin.random.Random

lateinit var bClass : ActivityGameBinding

class ActivityGame : AppCompatActivity() {

    fun weighted_random(values: List<Int>, weights: List<Int>): Int? {
        var total: Int = weights.sum()
        var n: Int = 0

        var num = Random.nextInt(1, total)

        for (i in values.indices) {
            n += weights[i]

            if (n >= num) {
                return values[i]
            }
        }
        return null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bClass = ActivityGameBinding.inflate(layoutInflater)
        setContentView(bClass.root)

        bClass.job1.setOnClickListener {
            bClass.buyWorkers.visibility = View.VISIBLE
        }
        bClass.job2.setOnClickListener {
            bClass.buyWorkers.visibility = View.VISIBLE
        }
        bClass.job3.setOnClickListener {
            bClass.buyWorkers.visibility = View.VISIBLE
        }
        bClass.job4.setOnClickListener {
            bClass.buyWorkers.visibility = View.VISIBLE
        }
        bClass.job5.setOnClickListener {
            bClass.buyWorkers.visibility = View.VISIBLE
        }
        bClass.job6.setOnClickListener {
            bClass.buyWorkers.visibility = View.VISIBLE
        }
        bClass.exitBuyMenu.setOnClickListener {
            bClass.buyWorkers.visibility = View.INVISIBLE
        }

    }
}