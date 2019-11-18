package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalculate.setOnClickListener(){
            calLoan()
        }

        btnReset.setOnClickListener(){
            txtcarPrice.text= null
            txtDownPayment.text=null
            txtIntRate.text=null
            txtLoanPeriod.text=null

            txtcarPrice.requestFocus()
            tVCarLoan.text=null
            tvInterest.text=null
            tVRepayment.text=null
        }
    }

    private fun calLoan() {
        val carPrice:Double = txtcarPrice.text.toString().toDouble()
        val downPayment:Double = txtDownPayment.text.toString().toDouble()
        val period:Double = txtLoanPeriod.text.toString().toDouble()
        val interestRate:Double = txtIntRate.text.toString().toDouble()

        val carLoan:Double = carPrice - downPayment
        val interest:Double = carLoan *interestRate/100 *period
        val monthlyRepayment:Double = (carLoan + interest)/period/12

        tVCarLoan.text="RM %.2f".format(carLoan)
        tvInterest.text = "RM %.2f".format(interest)
        tVRepayment.text = "RM %.2f".format(monthlyRepayment)
    }
}
