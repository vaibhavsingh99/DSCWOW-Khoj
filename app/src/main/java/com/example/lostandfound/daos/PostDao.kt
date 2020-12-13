package com.example.lostandfound.daos

import com.example.lostandfound.models.Post
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class PostDao {
    val db = FirebaseFirestore.getInstance()
    val postCollections = db.collection("posts")
    val auth = Firebase.auth

    fun addPost(
            name: String,
            fathername: String,
            age: String,
            height: String,
            gender: String,
            complexion: String,
            lastseendate: String,
            lastseencity: String,
            phone: String,
            clothing: String,
            address: String
    ) {
        GlobalScope.launch {
            val currentUserId = auth.currentUser!!.uid
            val userDao = UserDao()
            val user = userDao.getUserById(currentUserId).await()
                    .toObject(com.example.lostandfound.models.User::class.java)!!

            val currentTime = System.currentTimeMillis()
            val post = Post(
                    name,
                    fathername,
                    age,
                    height,
                    gender,
                    complexion,
                    lastseendate,
                    lastseencity,
                    phone,
                    clothing,
                    address,
                    user,
                    currentTime
            )
            postCollections.document().set(post)
        }
    }
}