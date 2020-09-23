package com.example.mvvm_room_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var liveText: MutableLiveData<String> = MutableLiveData()
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        liveText.observe(this, Observer {
            textView.text = it
        })

        button.setOnClickListener {
            liveText.value = "Hello World! ${++count}"
        }
    }
}