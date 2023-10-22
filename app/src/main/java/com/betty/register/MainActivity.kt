package com.betty.register

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.betty.register.databinding.ActivityMainBinding
import java.util.*


class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.birthdayButton.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                    binding.birthdayText.text = selectedDate
                }, year, month, day)

            datePickerDialog.show()
        }
        binding.register.setOnClickListener {
            var str = ""
            if (binding.firstName.text.toString().isEmpty()) {
                str += "First Name is empty\n"
            }
            if (binding.lastName.text.toString().isEmpty()) {
                str += "Last Name is empty\n"
            }
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
        }
    }
}
