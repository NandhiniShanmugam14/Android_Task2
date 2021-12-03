package com.example.android_task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var clickCount = 0

        val displayUserName = findViewById<TextView>(R.id.displayname)
        val clickMeButton = findViewById<TextView>(R.id.clickEvent)
        val userNameInputValue = findViewById<TextInputLayout>(R.id.nameText)
        val myMap = mutableMapOf<String, Int>()

        clickMeButton.setOnClickListener {
            clickCount++
            val userName = userNameInputValue.editText?.text?.toString()
            val markedUserName =
                if (userName.isNullOrEmpty()) "Somebody"
                else userName

            if(markedUserName in myMap)
            {
                clickCount = myMap[markedUserName.toString()]!!+1
                myMap[markedUserName.toString()] = clickCount
            }
            else
            {
                myMap.put(markedUserName.toString(), 1)
            }

            displayUserName.text = "$markedUserName is clicked ${myMap[markedUserName]} times"
        }
    }
}