package com.example.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var tipSelected: Double = 0.0
    var splitted: Boolean = false;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val amount: EditText = findViewById(R.id.chequeAmount)
        val button: Button = findViewById(R.id.calculate)
        var result: TextView = findViewById(R.id.result)
        val splitChequeNeeded: RadioButton = findViewById(R.id.splitRadio)
        fun onSplitBillClicked(view: View) {
            splitted = !splitted;
        }

        button.setOnClickListener { view ->
           result.text = calculateTip(tipSelected, amount.text.toString().toDouble(),splitted);
        }

        splitChequeNeeded.setOnClickListener {
            onSplitBillClicked(it)
        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu to use in the action bar
        val inflater = menuInflater
        inflater.inflate(R.menu.mian_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.fifteen -> {
                tipSelected = 0.15
                true
            }
            R.id.ten -> {
                tipSelected = 0.1
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}

private fun calculateTip(tipPercentage: Double, billAmount: Double, splitted: Boolean): String {

    val tipAmount = billAmount * tipPercentage
    val totalAmount = billAmount + tipAmount

    if(splitted) {
        return (totalAmount / 2).toString();
    } else{
        return totalAmount.toString();
    }
}