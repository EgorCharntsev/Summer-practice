package com.itis.firstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private var clickButton : Button? = null
    private var exit : ImageView? = null
    private var title : TextView? = null
    private var image : ImageView? = null
    private var name : EditText? = null
    private var age : EditText? = null
    private var height : EditText? = null
    private var weight : EditText? = null
    private var buttonAns: Button? = null
    private var angerSymbol : TextView? = null
    private var nameExc : TextView? = null
    private var ageExc : TextView? = null
    private var heightExc : TextView? = null
    private var weightExc : TextView? = null
    private var percent : TextView? = null
    private var amount : TextView? = null
    private var titleAns : TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clickButton = findViewById<Button>(R.id.button)
        exit = findViewById<ImageView>(R.id.exit)
        title = findViewById(R.id.title)
        image = findViewById<ImageView>(R.id.imageView4)
        name = findViewById(R.id.name)
        age = findViewById(R.id.age)
        height = findViewById(R.id.height)
        weight = findViewById(R.id.weight)
        buttonAns = findViewById<Button>(R.id.button_answer)
        angerSymbol = findViewById(R.id.anger_symbol)
        nameExc = findViewById(R.id.name_exception)
        ageExc = findViewById(R.id.age_exception)
        heightExc = findViewById(R.id.height_exception)
        weightExc = findViewById(R.id.weight_exception)
        percent = findViewById(R.id.percent)
        amount = findViewById(R.id.amount)
        titleAns = findViewById(R.id.title_ans)

        exit?.setOnClickListener {
            exitProcess(0);
        }

        clickButton?.setOnClickListener {
            it.visibility = View.GONE
            title?.visibility = View.GONE

            image?.visibility = View.VISIBLE
            name?.visibility = View.VISIBLE
            age?.visibility = View.VISIBLE
            height?.visibility = View.VISIBLE
            weight?.visibility = View.VISIBLE
            buttonAns?.visibility = View.VISIBLE
        }

        buttonAns?.setOnClickListener {
            val list = arrayOf(
                name?.text.toString(),
                age?.text.toString(),
                height?.text.toString(),
                weight?.text.toString())

            val listB = arrayOf(
                list[0].isNotEmpty() && list[0].length < 50,
                list[1].isNotEmpty() && list[1].toInt() > 0 && list[1].toInt() < 150,
                list[2].isNotEmpty() && list[2].toInt() > 0 && list[2].toInt() < 250,
                list[3].isNotEmpty() && list[3].toDouble() > 0 && list[3].toDouble() < 250.0
            )

            when (listB[0] && listB[1] && listB[2] && listB[3]) {
                true -> {
                    if (nameExc?.isVisible == true) nameExc?.visibility = View.INVISIBLE
                    if (ageExc?.isVisible == true) ageExc?.visibility = View.INVISIBLE
                    if (heightExc?.isVisible == true) heightExc?.visibility = View.INVISIBLE
                    if (weightExc?.isVisible == true) weightExc?.visibility = View.INVISIBLE

                    image?.visibility = View.GONE
                    name?.visibility = View.GONE
                    age?.visibility = View.GONE
                    height?.visibility = View.GONE
                    weight?.visibility = View.GONE
                    buttonAns?.visibility = View.GONE

                    amount?.text = "${getString(R.string.amount)} ${list[0].length * 1.0E+6 + list[1].toInt() * 12700}"
                    percent?.text = "${getString(R.string.percent)} ${((Math.abs(list[2].toInt() - list[3].toDouble()))/10)}%"

                    titleAns?.visibility = View.VISIBLE
                    amount?.visibility = View.VISIBLE
                    percent?.visibility = View.VISIBLE

                } false -> {
                    when (listB[0]) {
                        true -> {
                            if (nameExc?.isVisible == true) nameExc?.visibility = View.INVISIBLE
                        }
                        false -> {
                            if (nameExc?.isVisible == false) nameExc?.visibility = View.VISIBLE
                        }
                    }

                    when (listB[1]) {
                        true -> {
                            if (ageExc?.isVisible == true) ageExc?.visibility = View.INVISIBLE
                        }
                        false -> {
                            if (ageExc?.isVisible == false) ageExc?.visibility = View.VISIBLE
                        }
                    }

                    when (listB[2]) {
                        true -> {
                            if (heightExc?.isVisible == true) heightExc?.visibility = View.INVISIBLE
                        }
                        false -> {
                            if (heightExc?.isVisible == false) heightExc?.visibility = View.VISIBLE
                        }
                    }

                    when (listB[3]) {
                        true -> {
                            if (weightExc?.isVisible == true) weightExc?.visibility = View.INVISIBLE
                        }
                        false -> {
                            if (weightExc?.isVisible == false) weightExc?.visibility = View.VISIBLE
                        }
                    }

                    when (!listB[0] || !listB[1] || !listB[2] || !listB[3]) {
                        true -> {
                            if (angerSymbol?.isVisible == false) angerSymbol?.visibility = View.VISIBLE
                        } false -> {
                            if (angerSymbol?.isVisible == true) angerSymbol?.visibility = View.INVISIBLE
                        }
                    }
                }
            }
        }
    }
}
