package com.example.fish_note.signUp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.fish_note.R
import com.example.fish_note.databinding.ActivitySignUpAgeBinding
import com.example.fish_note.databinding.ActivitySignUpBinding
import com.google.android.material.textfield.MaterialAutoCompleteTextView

class SignUpAge : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpAgeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up_age)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up_age)

        // 나이대 옵션 설정
        val ageOptions = listOf("나이대를 선택해 주세요", "20대 이하", "30대", "40대", "50대", "60대", "70대 이상")
        val adapter = HintAdapter(this, android.R.layout.simple_list_item_1, ageOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.ageRange.setAdapter(adapter)

        // 드롭다운 선택 시 버튼 활성화 및 색상 변경
        binding.ageRange.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = adapter.getItem(position)
            binding.yearNextBtn1.isEnabled = true
            binding.yearNextBtn1.backgroundTintList = ContextCompat.getColorStateList(this, R.color.primaryBlue500)
        }

        binding.yearNextBtn1.setOnClickListener {
            val intent = Intent(this, SignUpGroup::class.java)
            startActivity(intent)
        }
    }
    private class HintAdapter(context: Context, resource: Int, objects: List<String>) :
        ArrayAdapter<String>(context, resource, objects) {

        override fun isEnabled(position: Int): Boolean {
            // Disable the first item
            return position != 0
        }

        override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view = super.getDropDownView(position, convertView, parent) as TextView
            if (position == 0) {
                // Set the hint text color
                view.setTextColor(ContextCompat.getColor(context, R.color.gray3))
            } else {
                view.setTextColor(ContextCompat.getColor(context, R.color.textBlack))
            }
            return view
        }
    }
}