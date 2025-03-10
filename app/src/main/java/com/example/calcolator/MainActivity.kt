package com.example.calcolator

import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.calcolator.databinding.ActivityCalculatorDesignBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalculatorDesignBinding
    var lastNumber: Double = 0.0
    var currentOperation: Operation? = null
    private var expression: StringBuilder = StringBuilder() // To store the full expression

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorDesignBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        setContentView(binding.root)

        addCallbacks()
        clearResult()
    }

    private fun addCallbacks() {
        binding.acButton.setOnClickListener {
            clearResult()
        }

        binding.backButton.setOnClickListener {
            val oldDigit = binding.finalResult.text.toString()
            if (oldDigit.isNotEmpty()) {
                binding.finalResult.text = oldDigit.substring(0, oldDigit.length - 1)
                updateResultDisplay()
            } else if (expression.isNotEmpty() && currentOperation == null) {
                expression = StringBuilder(expression.substring(0, expression.length - 1))
                updateResultDisplay()
            }
        }

        binding.sumButton.setOnClickListener {
            beforeOperation(Operation.ADD, "+")
        }

        binding.multiButton.setOnClickListener {
            beforeOperation(Operation.MULTIPLY, "×")
        }

        binding.divideButton.setOnClickListener {
            beforeOperation(Operation.DIVIDE, "÷")
        }

        binding.minisButton.setOnClickListener {
            beforeOperation(Operation.SUBTRACT, "-")
        }

        binding.resultButton.setOnClickListener {
            if (currentOperation != null && binding.finalResult.text.isNotEmpty()) {
                doOperation()
                expression.append(" = $lastNumber")
                binding.reuslt.text = getColoredExpression(expression.toString())
                binding.finalResult.text = lastNumber.toString()
                currentOperation = null
            }
        }

        binding.dotButtom.setOnClickListener {
            val oldDigit = binding.finalResult.text.toString()
            if (!oldDigit.contains('.')) {
                binding.finalResult.text = "$oldDigit."
                updateResultDisplay()
            }
        }
    }

    fun onClickNumber(v: View) {
        val newDigit = (v as Button).text.toString()
        val oldDigit = binding.finalResult.text.toString()
        binding.finalResult.text = oldDigit + newDigit
        updateResultDisplay()
    }

    private fun clearResult() {
        binding.finalResult.text = ""
        binding.reuslt.text = ""
        lastNumber = 0.0
        currentOperation = null
        expression = StringBuilder()
    }

    private fun beforeOperation(operation: Operation, symbol: String) {
        if (binding.finalResult.text.isNotEmpty()) {
            if (currentOperation != null) {
                doOperation() // Perform the previous operation if exists
                expression.append(" $symbol ")
            } else {
                lastNumber = binding.finalResult.text.toString().toDouble()
                expression = StringBuilder("$lastNumber $symbol ")
            }
            binding.reuslt.text = getColoredExpression(expression.toString())
            binding.finalResult.text = ""
            currentOperation = operation
        }
    }

    private fun doOperation() {
        val currentNumber = binding.finalResult.text.toString().toDouble()
        when (currentOperation) {
            Operation.ADD -> lastNumber += currentNumber
            Operation.SUBTRACT -> lastNumber -= currentNumber
            Operation.MULTIPLY -> lastNumber *= currentNumber
            Operation.DIVIDE -> lastNumber /= currentNumber
            null -> return
        }
        expression.append(currentNumber)
    }

    private fun updateResultDisplay() {
        if (currentOperation != null) {
            val tempExpression = StringBuilder(expression).append(binding.finalResult.text)
            binding.reuslt.text = getColoredExpression(tempExpression.toString())
        } else {
            binding.reuslt.text = binding.finalResult.text
        }
    }

    private fun getColoredExpression(expression: String): SpannableString {
        val spannable = SpannableString(expression)
        val blueColor = ContextCompat.getColor(this, android.R.color.holo_blue_dark)
        val operators = listOf("+", "-", "×", "÷", "=")
        for (operator in operators) {
            var index = expression.indexOf(operator)
            while (index >= 0) {
                spannable.setSpan(
                    ForegroundColorSpan(blueColor),
                    index,
                    index + operator.length,
                    SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                index = expression.indexOf(operator, index + 1)
            }
        }
        return spannable
    }
}

