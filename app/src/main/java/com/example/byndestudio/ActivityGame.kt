package com.example.byndestudio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.byndestudio.databinding.ActivityGameBinding
import java.util.Timer
import kotlin.random.Random

lateinit var bClass : ActivityGameBinding

class ActivityGame : AppCompatActivity() {

    var onMenu: Boolean = false
    var money: Int = Random.nextInt(100, 300)
    var days: Int = 31
    var currentJob: Int = 0
    var timer: Timer = Timer()
    var names: List<String> = listOf("Анрей", "Катя", "Антон")
    lateinit var defaultPerks: List<Perk>
    lateinit var persons: List<Person>

    class Perk(name: String, description: String) {
        val name: String
        val description: String

        init {
            this.name = name
            this.description = description
        }

        var designBonus: Int = 0
        var programmerBonus: Int = 0
        var marketingBonus: Int = 0
        var moodBonus: Int = 0
        var salaryBonus: Int = 0
    }

    class Person(name:String, avatar: Int, perksOut: List<Perk>) {
        val name: String
        var designSkill: Int
        var programmerSkill: Int
        var marketingSkill: Int
        var mood: Int
        var perks : Array<Perk?>
        var avatar: Int

        init {
            this.name = name
            this.avatar = avatar
            val values: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
            val weights: List<Int> = listOf(100, 95, 90, 80, 65, 50, 35, 20, 10, 5)

            designSkill = weighted_random(values, weights)!!
            programmerSkill = weighted_random(values, weights)!!
            marketingSkill = weighted_random(values, weights)!!
            mood = weighted_random(values, weights)!!

            val countPerk = getCountPerk()
            perks = Array(countPerk) { null }
            var i: Int = 0
            while (i < countPerk) {
                perks[i] = perksOut.random()
                i++
            }
        }

        private fun weighted_random(values: List<Int>, weights: List<Int>): Int? {
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

        private fun getCountPerk(): Int {
            return when (weighted_random(listOf(1, 2, 3), listOf(2, 3, 1))) {
                1 -> 0
                2 -> 1
                3 -> 2
                else -> 1
            }
        }

        fun getSalary(): Int {
            return designSkill * 10 + programmerSkill * 8 + marketingSkill * 12
        }

        fun next() {
            var random = Random.nextInt(1, 100)
            if (random < 30) {
                random = Random.nextInt(1, 3)
                when (random) {
                    1 -> programmerSkill++
                    2 -> designSkill++
                    3 -> marketingSkill++
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bClass = ActivityGameBinding.inflate(layoutInflater)
        setContentView(bClass.root)

        val jobs = listOf(bClass.job1, bClass.job2, bClass.job3, bClass.job4, bClass.job5, bClass.job6)

        for (i in jobs.indices) {
            jobs[i].setOnClickListener {
                currentJob = i
                if (onMenu) return@setOnClickListener
                onMenu = true
                bClass.buyWorkers.visibility = View.VISIBLE
                var url0 = "@drawable/worker${persons[0].avatar}"
                var imageResourse = resources.getIdentifier(url0, null, packageName)
                var res = resources.getDrawable(imageResourse)
                bClass.bAvatar1.setImageDrawable(res)
                bClass.nameOfWorker1.setText(persons[0].name)
                bClass.pointsOfWorker1.setText("П-${persons[0].programmerSkill} Д-${persons[0].designSkill} М-${persons[0].marketingSkill}")
                bClass.bButton1.setOnClickListener {
                    bClass.buyWorkers.visibility = View.INVISIBLE
                    jobs[i].setImageDrawable(res)
                }
            }
        }

        bClass.exitBuyMenu.setOnClickListener {
            if (!onMenu) return@setOnClickListener
            onMenu = false
            bClass.buyWorkers.visibility = View.INVISIBLE
        }
        
        bClass.money.setText(money)
        bClass.days.setText(days)
        
        val p1 = Perk("Ленивость", "Уменьшение всех статов")
        p1.designBonus -= 2
        p1.marketingBonus -= 2
        p1.programmerBonus -= 2
        p1.moodBonus += 2

        val p2 = Perk("Трудолюбие", "Повышение всех статов")
        p1.designBonus += 2
        p1.marketingBonus += 2
        p1.programmerBonus += 2
        p1.moodBonus -= 2

        val p3 = Perk("Креативность", "Лучше понимает в исскустве")
        p3.designBonus += 2

        defaultPerks = listOf(p1, p2, p3)

        persons = listOf(Person(names.random(), Random.nextInt(1, 6), defaultPerks),Person(names.random(), Random.nextInt(1, 6), defaultPerks), Person(names.random(), Random.nextInt(1, 6), defaultPerks))

//        timer.schedule(nextDay()!!, 1000 * 60)
    }

    fun nextDay() {

    }
}