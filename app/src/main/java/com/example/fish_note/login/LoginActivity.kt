package com.example.fish_note.login

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.fish_note.R
import com.example.fish_note.databinding.ActivityLoginBinding
import com.kakao.sdk.user.UserApiClient


class LoginActivity : AppCompatActivity() {

    private val kakaoAuthViewModel: KakaoAuthViewModel by viewModels()

    private lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val isLoggedIn = kakaoAuthViewModel.isLoggedIn
        binding.kakaoButton.setOnClickListener{
            kakaoAuthViewModel.kakaoLogin()
        }

        UserApiClient.instance.me { user, error ->
            if (error != null) {
                Log.e("카카오", "$error")
            }
            if (user != null) {
                Log.d("카카오", "$user")
            }
        }


    }
}