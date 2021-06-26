package com.example.exampleGithubPackages

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import com.example.exampleLibrary.ExampleLibrary

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.tv_greeting).text = ExampleLibrary.greetMe()
    }
}