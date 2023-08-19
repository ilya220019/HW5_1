package com.example.fv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.fv.databinding.ActivityMainBinding
import com.example.fv.view.CounterView

class MainActivity : AppCompatActivity(),CounterView {

    private lateinit var binding:ActivityMainBinding
    private var presenter = Presenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClicker()
        presenter.attachView(this)

    }

    private fun initClicker() = with(binding){
        btnPlus.setOnClickListener{
            presenter.increment()
        }
        btnMinus.setOnClickListener{
            presenter.decrement()

        }
    }

    override fun showCount(number: Int) {
        binding.tvNumber.text = number.toString()

    }

    override fun showToast(massage: String) {
        Toast.makeText(applicationContext, massage, Toast.LENGTH_SHORT).show()
    }

    override fun chengColor(color: Int) {
       binding.tvNumber.setTextColor(color)
    }
}