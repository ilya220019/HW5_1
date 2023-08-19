package com.example.fv

import android.graphics.Color
import com.example.fv.model.CounterModel
import com.example.fv.view.CounterView

class Presenter {

    private val model = CounterModel()
    private lateinit var counterView: CounterView

    fun increment() {
        model.increment()
        counterView.showCount(model.number)

        if (model.number == 10){
            counterView.showToast("Поздравляем")
        }
        if (model.number == 15){
            counterView.chengColor(Color.GREEN)
        }
    }

    fun attachView(view: CounterView) {
        this.counterView = view
    }

    fun decrement() {
        model.decrement()
        counterView.showCount(model.number)
    }
}