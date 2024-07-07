package com.example.fish_note.signUp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.fish_note.R
import com.example.fish_note.databinding.ActivitySignUpWayfishBinding
import com.example.fish_note.databinding.ActivitySignUpWithMapBinding

class SignUpWithMap : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpWithMapBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up_with_map)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up_with_map)
        binding.yearNextBtn5.setOnClickListener {
            val intent = Intent(this, Permission::class.java)
            startActivity(intent)
        }
    }
}