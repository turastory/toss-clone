package com.turastory.tossclone.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.turastory.tossclone.R
import com.turastory.tossclone.databinding.LayoutAllBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: LayoutAllBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutAllBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHelpCenter.setOnClickListener {
            toast("Clicked ${getString(R.string.main_all_help_center)}")
        }

        binding.btnSettings.setOnClickListener {
            toast("Clicked ${getString(R.string.main_all_settings)}")
        }
    }

    private fun toast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}