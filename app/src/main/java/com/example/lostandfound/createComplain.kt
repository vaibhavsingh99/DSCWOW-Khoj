package com.example.lostandfound

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lostandfound.daos.PostDao
import kotlinx.android.synthetic.main.activity_create_complain.*

class createComplain : AppCompatActivity() {
    private lateinit var postDao: PostDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_complain)
        postDao = PostDao()

        reportbutton.setOnClickListener {
            val input = PersonName.text.toString().trim()
            val input2 = fathername.text.toString().trim()
            val input3 = age.text.toString().trim()
            val input4 = height.text.toString().trim()
            val input5 = gender.text.toString().trim()
            val input6 = editTextTextPersonName4.text.toString().trim()
            val input7 = lastseendate.text.toString().trim()
            val input8 = lastseencity.text.toString().trim()
            val input9 = phone.text.toString().trim()
            val input10 = clothing.text.toString().trim()
            val input11 = address.text.toString().trim()

            if (input.isNotEmpty()) {
                postDao.addPost(
                        input,
                        input2,
                        input3,
                        input4,
                        input5,
                        input6,
                        input7,
                        input8,
                        input9,
                        input10,
                        input11
                )
                finish()

            }
        }
    }

}