package com.example.userprofile

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.design.widget.TextInputLayout
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.CheckBox
import android.widget.DatePicker
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var fullNameLayout: TextInputLayout
    private lateinit var editFullName: TextInputEditText
    private lateinit var phoneNumberLayout: TextInputLayout
    private lateinit var editPhoneNumber: TextInputEditText
    private lateinit var emailLayout: TextInputLayout
    private lateinit var editEmail: TextInputEditText
    private lateinit var countryAutoCompleteView: AutoCompleteTextView
    private lateinit var editAddress: TextInputEditText
    private lateinit var dobDatePicker: DatePicker
    private lateinit var radioGroupGender: RadioGroup
    private lateinit var readingCheckbox : CheckBox
    private lateinit var musicCheckbox : CheckBox
    private lateinit var sportsCheckbox : CheckBox
    private lateinit var spinnerSSC: Spinner
    private lateinit var spinnerBCA: Spinner
    private lateinit var seekbarSSC: SeekBar
    private lateinit var seekbarBCA: SeekBar
    private lateinit var sscPercentageValue: TextView
    private lateinit var bcaPercentageValue: TextView
    private lateinit var btnSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeData()
    }

    private fun initializeData() {
        fullNameLayout = findViewById(R.id.fullNameLayout)
        editFullName = findViewById(R.id.edtFullName)
        phoneNumberLayout = findViewById(R.id.phoneNumberLayout)
        editPhoneNumber = findViewById(R.id.edtPhoneNumber)
        emailLayout = findViewById(R.id.emailLayout)
        editEmail = findViewById(R.id.edtEmail)
        countryAutoCompleteView = findViewById(R.id.countryAutoCompleteView)
        editAddress = findViewById(R.id.edtAddress)
        dobDatePicker = findViewById(R.id.dobDatepicker)
        radioGroupGender = findViewById(R.id.radioGroupGender)
        readingCheckbox = findViewById(R.id.readingCheckbox)
        musicCheckbox = findViewById(R.id.musicCheckbox)
        sportsCheckbox = findViewById(R.id.sportsCheckbox)
        spinnerSSC = findViewById(R.id.spinnerSSC)
        spinnerBCA = findViewById(R.id.spinnerBCA)
        seekbarSSC = findViewById(R.id.seekbarSSC)
        seekbarBCA = findViewById(R.id.seekbarBCA)
        sscPercentageValue = findViewById(R.id.sscPercentageValue)
        bcaPercentageValue = findViewById(R.id.bcaPercentageValue)
        btnSubmit = findViewById(R.id.btnSubmit)

        val countryAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, resources.getStringArray(R.array.county_list))
        countryAutoCompleteView.setAdapter(countryAdapter)


        val sscOptions = arrayOf(getString(R.string.ssc), getString(R.string.hsc))
        val bcaOptions = arrayOf(getString(R.string.bca), getString(R.string.bcom))
        val sscAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, sscOptions)
        spinnerSSC.adapter = sscAdapter

        val bcaAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, bcaOptions)
        spinnerBCA.adapter = bcaAdapter

        seekbarSSC.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                sscPercentageValue.text = progress.toString() + getString(R.string.percentageSymbol)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // This is called when the user starts to touch the SeekBar
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // This is called when the user stops touching the SeekBar
            }
        })

        seekbarBCA.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                bcaPercentageValue.text = progress.toString() + getString(R.string.percentageSymbol)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // This is called when the user starts to touch the SeekBar
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // This is called when the user stops touching the SeekBar
            }
        })

    }

    fun onClickSubmit(view: View) {
        if(validateValues()) {
            Toast.makeText(this, getString(R.string.success), Toast.LENGTH_SHORT).show()
        }
    }

    private fun validateValues(): Boolean {
        var isValid = true
        if(editFullName.text.toString().isEmpty()) {
            fullNameLayout.error = getString(R.string.full_name_Error)
            isValid = false
        }
        if(editPhoneNumber.text.toString().isEmpty()) {
            phoneNumberLayout.error = getString(R.string.phone_error)
            isValid = false
        }
        if(editEmail.text.toString().isEmpty()) {
            emailLayout.error = getString(R.string.email_error)
            isValid = false
        }
        if (isValid) {
            fullNameLayout.isErrorEnabled = false
            phoneNumberLayout.isErrorEnabled = false
            emailLayout.isErrorEnabled = false
        }
        return  isValid
    }
}

