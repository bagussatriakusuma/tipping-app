package com.example.challengechapter2.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.challengechapter2.R
import com.example.challengechapter2.databinding.ActivityHomeBinding
import java.util.Objects

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bindEditTextWithPrefix()
        bindCardViewWithEditText()
        setRadioButtonCheck()
    }

    fun bindEditTextWithPrefix() {
        binding.etCos.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                val text = s.toString()
                if (!text.startsWith("Rp")) {
                    binding.etCos.setText("Rp $text")
                    binding.etCos.setSelection(binding.etCos.text?.length ?: 0)
                }
            }
        })
    }

    fun addToEditText(amount: Int) {
        val etCos = binding.etCos.text.toString()
        val etCosWithoutPrefix = etCos.replace("Rp ", "")

        val currentAmount = try {
            etCosWithoutPrefix.toInt()
        } catch (e: NumberFormatException) {
            0
        }
        val newAmount = currentAmount + amount

        binding.etCos.setText("Rp $newAmount")
        binding.etCos.setSelection(binding.etCos.text?.length ?: 0)
    }

    fun bindCardViewWithEditText(){
        binding.cv5k.setOnClickListener {
            addToEditText(5000)
        }

        binding.cv10k.setOnClickListener {
            addToEditText(10000)
        }

        binding.cv15k.setOnClickListener {
            addToEditText(15000)
        }

        binding.cv20k.setOnClickListener {
            addToEditText(20000)
        }

        binding.cv25k.setOnClickListener {
            addToEditText(25000)
        }

        binding.cv30k.setOnClickListener {
            addToEditText(30000)
        }
    }

    fun setRadioButtonCheck(){
        binding.cvAmazing.setOnClickListener {
            binding.cvAmazing.isChecked = true
            binding.cvAmazing.foreground = ContextCompat.getDrawable(this, R.drawable.bg_card_service)
            binding.rbAmazing.isChecked = true

            binding.cvGood.isChecked = false
            binding.rbGood.isChecked = false
            binding.cvOk.isChecked = false
            binding.rbOk.isChecked = false
        }

        binding.cvGood.setOnClickListener {
            binding.cvGood.isChecked = true
            binding.cvGood.foreground = ContextCompat.getDrawable(this, R.drawable.bg_card_service)
            binding.rbGood.isChecked = true

            binding.cvAmazing.isChecked = false
            binding.rbAmazing.isChecked = false
            binding.cvOk.isChecked = false
            binding.rbOk.isChecked = false
        }

        binding.cvOk.setOnClickListener {
            binding.cvOk.isChecked = true
            binding.cvOk.foreground = ContextCompat.getDrawable(this, R.drawable.bg_card_service)
            binding.rbOk.isChecked = true

            binding.cvAmazing.isChecked = false
            binding.rbAmazing.isChecked = false
            binding.cvGood.isChecked = false
            binding.rbGood.isChecked = false
        }
    }
}