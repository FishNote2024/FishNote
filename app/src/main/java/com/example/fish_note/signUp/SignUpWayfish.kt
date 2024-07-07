package com.example.fish_note.signUp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.fish_note.R
import com.example.fish_note.databinding.ActivitySignUpKindFishBinding
import com.example.fish_note.databinding.ActivitySignUpWayfishBinding

class SignUpWayfish : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpWayfishBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up_wayfish)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up_wayfish)
        binding.yearNextBtn4.setOnClickListener {
            val intent = Intent(this, SignUpWithMap::class.java)
            startActivity(intent)
        }
    }
}