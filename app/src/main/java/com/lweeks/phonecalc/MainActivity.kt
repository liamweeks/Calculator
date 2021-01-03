package com.lweeks.phonecalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var isNewOp = true
    var oldnum = ""
    var op = "+" // + is our default operator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun numberEvent(view: View) {
        if (isNewOp){ answer.setText("")}
        isNewOp = false
        var btnclick = answer.text.toString()
        var btnselect = view as Button

        when (btnselect.id){
            onebtn.id -> {btnclick += "1"}
            twobtn.id -> {btnclick += "2"}
            threebtn.id -> {btnclick += "3"}
            fourbtn.id -> {btnclick += "4"}
            fivebtn.id -> {btnclick += "5"}
            sixbtn.id -> {btnclick += "6"}
            sevenbtn.id -> {btnclick += "7"}
            eightbtn.id -> {btnclick += "8"}
            ninebtn.id -> {btnclick += "9"}
            zerobtn.id -> {btnclick += "0"}
            dot.id -> {btnclick += "."}
            plusminus.id -> {btnclick = "-$btnclick"}
            pi.id -> {btnclick += "3.141593"}


        }
        answer.setText(btnclick)

    }

    fun operatorEvent(view: View) {
        isNewOp = true
        oldnum = answer.text.toString()
        var btnselect: Button = view as Button

        when(btnselect.id) {
            multiply.id -> {op = "*"}
            divide.id -> {op = "/"}
            addition.id -> {op = "+"}
            subtract.id  -> {op = "-"}
        }
    }

    fun equal(view: View) {
        var newnum = answer.text.toString()
        var result = 0.0

        when (op) {
            "+" -> {result = oldnum.toDouble() + newnum.toDouble()}
            "-" -> {result = oldnum.toDouble() - newnum.toDouble()}
            "*" -> {result = oldnum.toDouble() * newnum.toDouble()}
            "/" -> {result = oldnum.toDouble() / newnum.toDouble()}

        }
        answer.setText(result.toString())
    }

    fun cancelEvent(view: View) {
        answer.text = "0"
        isNewOp = true
    }

    fun percentEvent(view: View) {
        var num = answer.text.toString().toDouble()/100
        answer.setText(num.toString())
        isNewOp = true


    }

}
