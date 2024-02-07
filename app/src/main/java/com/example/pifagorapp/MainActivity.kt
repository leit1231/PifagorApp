package com.example.pifagorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.pifagorapp.databinding.ActivityMainBinding
import java.lang.Math.sqrt
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onClickResult(view: View){
        if (!isFielEmpty()){
            val result = getresult()
            binding.textResult.text = getString(R.string.result_info) + result
        }
    }

    private fun isFielEmpty(): Boolean{
        binding.apply {
            if (edA.text.isNullOrEmpty()) edA.error = "Поле должно быть заполнено!"
            if (edB.text.isNullOrEmpty()) edB.error = "Поле должно быть заполнено!"
            return edA.text.isNullOrEmpty() || edB.text.isNullOrEmpty()
        }
    }
    private  fun getresult(): String{
        val a:Double
        val b:Double
        binding.apply {
            a = edA.text.toString().toDouble()
            b = edB.text.toString().toDouble()
        }
        return sqrt((a.pow(2) + b.pow(2))).toString()
    }
}