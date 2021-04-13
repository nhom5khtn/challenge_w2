package com.example.android.firstweekchallenge


//**                      **
//**      SINGLETON       **
//**                      **

public class DataStore private constructor(){

    init {
        println("Initialize account ... ")
    }


    companion object {
        var fullName:String?="";
        var email:String?="";
        var password:String?="";


        init{
            println("Account(email='$email', fullName='$fullName', password='$password')")
        }

    }

}

//object DataStore {
//    fun dataStore(){
//        print("DataStore")
//    }
