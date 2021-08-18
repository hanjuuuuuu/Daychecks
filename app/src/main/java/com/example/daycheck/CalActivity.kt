package com.example.daycheck

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import androidx.annotation.RequiresApi

//달력 화면
class CalActivity : AppCompatActivity() {
    lateinit var addBtn: Button
    lateinit var calendarView: CalendarView
    lateinit var diaryTextView: TextView
    lateinit var personmood: TextView
    lateinit var personsymptom: TextView
    lateinit var personexercise: TextView
    lateinit var persondrink: TextView
    lateinit var personsmoking: TextView
    lateinit var personsleep: TextView


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cal)


        addBtn = findViewById(R.id.add_Btn)
        calendarView = findViewById(R.id.calendarView)
        diaryTextView = findViewById(R.id.diaryTextView)
        personmood = findViewById(R.id.person_mood)
        personsymptom = findViewById(R.id.person_symptom)
        personexercise = findViewById(R.id.person_exercise)
        persondrink = findViewById(R.id.person_drink)
        personsmoking = findViewById(R.id.person_smoking)
        personsleep = findViewById(R.id.person_sleep)


        intent.putExtra("todaydate",diaryTextView.text)
        calendarView.callOnClick()

        //달력 날짜 선택되면 날짜 표시
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            diaryTextView.visibility = View.VISIBLE
            diaryTextView.text = String.format("%d - %d - %d", year, month + 1, dayOfMonth)

            val date = diaryTextView.text
            val SharedPreferences = getSharedPreferences("$date",0)
            personmood.text = SharedPreferences.getString("mood","-")
            personsymptom.text = SharedPreferences.getString("symptom","-")
            personexercise.text = SharedPreferences.getString("Exercising","-")
            persondrink.text = SharedPreferences.getString("Drinking","-")
            personsmoking.text = SharedPreferences.getString("Smoking", "-")
            personsleep.text = SharedPreferences.getString("Sleeping", "-")


        }

        //추가 버튼을 누르면 DayActivity로 이동
        addBtn.setOnClickListener {
            val intent = Intent(this, DayActivity::class.java)

            val date = diaryTextView.text
            intent.putExtra("todaydate",date)
            startActivity(intent)

        }


    }



}