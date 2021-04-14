package com.example.android.firstweekchallenge


//**                      **
//**      SINGLETON       **
//**                      **

public class DataStore private constructor(){

    init {
        println("Initialize account ... ")
    }

    private object Holder {val account = DataStore()}

    companion object {
        var fullName:String?="";
        var email:String?="";
        var password:String?="";
        var phoneNumber:String?="";


        fun getInstance():DataStore {
            return Holder.account
        }

        init{
            println("Account(email='$email', fullName='$fullName', password='$password')")
        }



    }

}

//object DataStore {
//    fun dataStore(){
//        print("DataStore")
//    }
