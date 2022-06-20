package com.example.myapplication20

import androidx.multidex.MultiDexApplication
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage
import com.kakao.sdk.common.KakaoSdk

class MyApplication: MultiDexApplication() {
    companion object{
        lateinit var auth: FirebaseAuth
        var email:String?=null
        lateinit var db : FirebaseFirestore
        lateinit var storage:FirebaseStorage

        fun checkAuth() : Boolean{
            var currentUser = auth.currentUser
            return currentUser?.let{
                email=currentUser.email
                currentUser.isEmailVerified
            }?: let{
                false
            }
        }
    }

    override fun onCreate() {
        super.onCreate()
        auth = Firebase.auth
        KakaoSdk.init(this, "094d887a80cc52d37eb3fe323adee61c")

        db = FirebaseFirestore.getInstance()
        storage = Firebase.storage
    }
}