package com.example.fish_note.signUp

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.fish_note.R
import com.example.fish_note.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private var isTextChangedByUser = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)

        // EditText에 TextWatcher를 추가하여 입력 변경을 감지
        binding.yearsOfExperience.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (isTextChangedByUser) {
                    isTextChangedByUser = false
                    val inputText = s.toString().replace(" 년", "")
                    // 입력이 비어있는지 확인하여 버튼 활성화/비활성화
                    val isNotEmpty = inputText.isNotEmpty()
                    binding.yearNextBtn0.isEnabled = isNotEmpty
                    // 입력 필드가 비어있지 않으면 버튼 색상을 활성화 색상으로 변경
                    val color = if (isNotEmpty) R.color.primaryBlue500 else R.color.gray2
                    binding.yearNextBtn0.backgroundTintList =
                        ContextCompat.getColorStateList(this@SignUpActivity, color)
                    if (inputText.isNotEmpty()) {
                        binding.yearsOfExperience.setText("$inputText 년")
                        binding.yearsOfExperience.setSelection(inputText.length)
                    } else {
                        binding.yearsOfExperience.setText("")
                    }
                    isTextChangedByUser = true
                }
            }
        })

        binding.yearNextBtn0.setOnClickListener {
            val intent = Intent(this, SignUpAge::class.java)
            startActivity(intent)
        }
    }
}