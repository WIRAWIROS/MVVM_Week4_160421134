package com.ubaya.mvvm_160421134.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ubaya.mvvm_160421134.model.Drinks
import com.ubaya.mvvm_160421134.model.Student

class ListViewModel(application: Application): AndroidViewModel(application) {
    val studentsLD = MutableLiveData<ArrayList<Student>>()
    val DrinksLD = MutableLiveData<ArrayList<Drinks>>()
    val DrinksLoadErrorLD = MutableLiveData<Boolean>()
    val studentLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun refresh() {
        studentLoadErrorLD.value = false
        loadingLD.value = true

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.0.2.2/drink/drink.json"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<List<Student>>() { }.type
                val result = Gson().fromJson<List<Student>>(it, sType)
                studentsLD.value = result as ArrayList<Student>?
                loadingLD.value = false

                Log.d("show_volley", it)
            },
            {
                Log.e("show_volley", it.toString())
                studentLoadErrorLD.value = false
                loadingLD.value = false
            })
        stringRequest.tag = TAG
        queue?.add(stringRequest)

    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}