package com.example.mvvm_room_retrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import com.example.mvvm_room_retrofit.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val liveText = MutableLiveData<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            lifecycleOwner = this@MainActivity  // **중요** binding에 LifeCycleOwner을 지정해줘야 LiveData가 실시간으로 변화
            activity = this@MainActivity        // xml 파일에 선언한 activity
        }
    }

    fun updateTextViewWithEditText () {
        liveText.value = editText.text.toString()
    }
}