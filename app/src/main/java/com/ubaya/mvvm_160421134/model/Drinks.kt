package com.ubaya.mvvm_160421134.model

data class Drinks(
    val id:String?,
    val name:String?,
    val category:String?,
    val ingredients:List<String>?,
    val extras:ToppingTambahan?,
    val images:String?
)
data class ToppingTambahan(
    val sugar:String?,
    val ice:String?
)
