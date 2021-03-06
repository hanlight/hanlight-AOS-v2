package com.portfolio.makeitportfolio.hanlight_aos

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.content.res.AppCompatResources

class Collection {
    fun changeBackground(
        context: Context,
        editText1: EditText,
        button: Button
    ) { //editText가 1개인 layout 일 때 사용
        editText1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                editText1.background =
                    AppCompatResources.getDrawable(context, R.drawable.edittext_success_style)
            }

            override fun afterTextChanged(s: Editable?) {
                if (s.isNullOrBlank() || s.isNullOrEmpty()) {
                    editText1.background =
                        AppCompatResources.getDrawable(context, R.drawable.edittext_style)
                    button.background =
                        AppCompatResources.getDrawable(context, R.drawable.button_style)
                } else {
                    button.background =
                        AppCompatResources.getDrawable(context, R.drawable.button_success)
                }
            }

        })
    }

    fun changeBackground(
        context: Context,
        editText1: EditText,
        editText2: EditText,
        button: Button
    ) {//editText가 2개인 layout 일 때 사용
        var id = 0 //editText1이 채워져있는지
        var psw = 0 //editText2가 채워져있는지

        editText1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (s.isNullOrBlank() || s.isNullOrEmpty()) { //editText1이 비어있다면
                    editText1.background =
                        AppCompatResources.getDrawable(context, R.drawable.edittext_style)
                    id = 0
                } else { //editText1이 비어있지 않다면
                    editText1.background =
                        AppCompatResources.getDrawable(context, R.drawable.edittext_success_style)
                    id = 1
                }
                if (id == 1 && psw == 1) {
                    button.background =
                        AppCompatResources.getDrawable(context, R.drawable.button_success)
                } else {
                    button.background =
                        AppCompatResources.getDrawable(context, R.drawable.button_style)
                }
            }

        })

        editText2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (s.isNullOrBlank() || s.isNullOrEmpty()) {//editText3이 비어있다면
                    editText2.background =
                        AppCompatResources.getDrawable(context, R.drawable.edittext_style)
                    psw = 0
                } else {//editText2이 비어있지 않다면
                    editText2.background =
                        AppCompatResources.getDrawable(context, R.drawable.edittext_success_style)
                    psw = 1
                }
                if (id == 1 && psw == 1) {
                    button.background =
                        AppCompatResources.getDrawable(context, R.drawable.button_success)
                } else {
                    button.background =
                        AppCompatResources.getDrawable(context, R.drawable.button_style)
                }
            }

        })
    }

    fun changeBackground(
        context: Context,
        editText1: EditText,
        editText2: EditText,
        editText3: EditText,
        button: Button
    ) {
        var id = 0//editText1가 채워져있는지
        var psw = 0//editText2가 채워져있는지
        var repsw = 0//editText3가 채워져있는지
        editText1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (s.isNullOrBlank() || s.isNullOrEmpty()) {//editText1이 비어있다면
                    editText1.background =
                        AppCompatResources.getDrawable(context, R.drawable.edittext_style)
                    id = 0
                } else {//editText1이 비어있지 않다면
                    editText1.background =
                        AppCompatResources.getDrawable(context, R.drawable.edittext_success_style)
                    id = 1
                }
                if (id == 1 && psw == 1 && repsw == 1) {
                    button.background =
                        AppCompatResources.getDrawable(context, R.drawable.button_success)
                } else {
                    button.background =
                        AppCompatResources.getDrawable(context, R.drawable.button_style)
                }
            }

        })

        editText2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (s.isNullOrBlank() || s.isNullOrEmpty()) {//editText2이 비어있다면
                    editText2.background =
                        AppCompatResources.getDrawable(context, R.drawable.edittext_style)
                    psw = 0
                } else {//editText2이 비어있지 않다면
                    editText2.background =
                        AppCompatResources.getDrawable(context, R.drawable.edittext_success_style)
                    psw = 1
                }
                if (id == 1 && psw == 1 && repsw == 1) {
                    button.background =
                        AppCompatResources.getDrawable(context, R.drawable.button_success)
                } else {
                    button.background =
                        AppCompatResources.getDrawable(context, R.drawable.button_style)
                }
            }

        })

        editText3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (s.isNullOrBlank() || s.isNullOrEmpty()) { //editText3이 비어있다면
                    editText3.background =
                        AppCompatResources.getDrawable(context, R.drawable.edittext_style)
                    repsw = 0
                } else { //editText3이 비어있지 않다면
                    editText3.background =
                        AppCompatResources.getDrawable(context, R.drawable.edittext_success_style)
                    repsw = 1
                }
                if (id == 1 && psw == 1 && repsw == 1) {
                    button.background =
                        AppCompatResources.getDrawable(context, R.drawable.button_success)
                } else {
                    button.background =
                        AppCompatResources.getDrawable(context, R.drawable.button_style)
                }
            }

        })
    }

}