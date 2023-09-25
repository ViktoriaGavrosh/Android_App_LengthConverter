package com.viktoriagavrosh.lengthconverter

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.viktoriagavrosh.lengthconverter.databinding.ActivityMainBinding
import kotlin.math.roundToInt

const val CM_IN_INCH = 2.54
const val CM_IN_FOOT = 30.48
const val CM_IN_YARD = 91.44


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.convertButton.setOnClickListener {
            val inputNumber = binding.howMuchEditText.text.toString()
            if (inputNumber == "" || inputNumber == ".") {
                Toast.makeText(this, "Enter the number, please", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            val result = convert(inputNumber.toDouble())
            showResult(result)
        }

        binding.howMuchEditText.setOnKeyListener { v, keyCode, _ ->
            handleKeyEvent(v, keyCode)
        }
    }

    private fun convert(num: Double) = when (binding.lengthGroup.checkedRadioButtonId) {
        R.id.length_inches -> num * CM_IN_INCH
        R.id.length_feet -> num * CM_IN_FOOT
        else -> num * CM_IN_YARD
    }

    private fun showResult(result: Double) {
        if (binding.centimetersSwitch.isChecked) {
            binding.resultMeters.text = "0"
            binding.resultCentimeters.text = result.roundToInt().toString()
        } else {
            binding.resultMeters.text = (result / 100).roundToInt().toString()
            binding.resultCentimeters.text = (result % 100).roundToInt().toString()
        }
    }

    private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken,0)
            return true
        }
        return false
    }
}

