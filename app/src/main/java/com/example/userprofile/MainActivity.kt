package com.example.userprofile

import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.design.widget.TextInputLayout
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var fullNameLayout: TextInputLayout
    private lateinit var editFullName: TextInputEditText
    private lateinit var phoneNumberLayout: TextInputLayout
    private lateinit var editPhoneNumber: TextInputEditText
    private lateinit var emailLayout: TextInputLayout
    private lateinit var editEmail: TextInputEditText
    private lateinit var countryAutoCompleteView: AutoCompleteTextView
    private lateinit var addressLayout: TextInputLayout
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
        addressLayout = findViewById(R.id.addressLayout)
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

        editFullName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // This is called before text change
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(s?.isNotBlank() == true) {
                    fullNameLayout.isErrorEnabled = false
                } else {
                    fullNameLayout.error = getString(R.string.full_name_Error)
                }
            }

            override fun afterTextChanged(s: Editable?) {
                // This is called after text change
            }
        })

        editPhoneNumber.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // This is called before text change
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(s?.isNotBlank() == true) {
                    phoneNumberLayout.isErrorEnabled = false
                } else {
                    phoneNumberLayout.error = getString(R.string.phone_error)
                }
            }

            override fun afterTextChanged(s: Editable?) {
                // This is called after text change
            }
        })

        editEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // This is called before text change
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(s?.isNotBlank() == true) {
                    emailLayout.isErrorEnabled = false
                } else {
                    emailLayout.error = getString(R.string.email_error)
                }
            }

            override fun afterTextChanged(s: Editable?) {
                // This is called after text change
            }
        })

        editAddress.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // This is called before text change
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(s?.isNotBlank() == true) {
                    addressLayout.isErrorEnabled = false
                } else {
                    addressLayout.error = getString(R.string.address_error)
                }
            }

            override fun afterTextChanged(s: Editable?) {
                // This is called after text change
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
        val contactNumber: String = editPhoneNumber.text.toString()
        var validationErrorMessage = getString(R.string.please)
        if(editFullName.text.toString().isEmpty()) {
            fullNameLayout.error = getString(R.string.full_name_Error)
            isValid = false
        }
        if(contactNumber.isEmpty()) {
            phoneNumberLayout.error = getString(R.string.phone_error)
            isValid = false
        }
        if(!contactNumber.matches("\\d{10}".toRegex())) {
            phoneNumberLayout.error = getString(R.string.invalid_phone_error)
            isValid = false
        }
        if(editEmail.text.toString().isEmpty()) {
            emailLayout.error = getString(R.string.email_error)
            isValid = false
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(editEmail.text.toString()).matches()) {
            emailLayout.error = getString(R.string.invalid_email_error)
            isValid = false
        }
        if(editAddress.text.toString().isEmpty()) {
            addressLayout.error = getString(R.string.address_error)
            isValid = false
        }
        if(countryAutoCompleteView.text.toString().isEmpty()) {
            isValid = false
            validationErrorMessage = getValidationErrorMessageFormat(validationErrorMessage)
            validationErrorMessage += getString(R.string.country_error)
        }
        if(radioGroupGender.checkedRadioButtonId == -1) {
            isValid = false
            validationErrorMessage = getValidationErrorMessageFormat(validationErrorMessage)
            validationErrorMessage += getString(R.string.select_gender)
        }
        if(!readingCheckbox.isChecked && !musicCheckbox.isChecked && !sportsCheckbox.isChecked) {
            isValid = false
            validationErrorMessage = getValidationErrorMessageFormat(validationErrorMessage)
            validationErrorMessage += getString(R.string.hobby_Error)
        }
        if(seekbarSSC.progress == 0) {
            isValid = false
            validationErrorMessage = getValidationErrorMessageFormat(validationErrorMessage)
            validationErrorMessage += getString(R.string.ssc_percentage_Error)
        }
        if(seekbarBCA.progress == 0) {
            isValid = false
            validationErrorMessage = getValidationErrorMessageFormat(validationErrorMessage)
            validationErrorMessage += getString(R.string.bca_percentage_Error)
        }
        if (isValid) {
            fullNameLayout.isErrorEnabled = false
            phoneNumberLayout.isErrorEnabled = false
            emailLayout.isErrorEnabled = false
            addressLayout.isErrorEnabled = false
        }
        if(validationErrorMessage != getString(R.string.please)) {
            Toast.makeText(this, validationErrorMessage, Toast.LENGTH_LONG).show()
        }
        return  isValid
    }

    private fun getValidationErrorMessageFormat(validationErrorMessage: String): String {
        if(validationErrorMessage != getString(R.string.please)) {
            return "$validationErrorMessage, "
        }
        return "$validationErrorMessage "
    }
}

