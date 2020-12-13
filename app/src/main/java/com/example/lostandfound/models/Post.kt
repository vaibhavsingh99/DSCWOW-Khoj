package com.example.lostandfound.models

data class Post(
        val name: String = "",
        val fathername: String = "",
        val age: String = "",
        val height: String = "",
        val gender: String = "",
        val complexion: String = "",
        val lastseendate: String = "",
        val lastseencity: String = "",
        val phone: String = "",
        val clothing: String = "",
        val address: String = "",
        val createdBy: User = User(),
        val createdAt: Long = 0L,
        val likedBy: ArrayList<String> = ArrayList()
)