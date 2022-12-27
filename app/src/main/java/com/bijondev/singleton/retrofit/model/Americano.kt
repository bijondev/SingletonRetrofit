package com.bijondev.singleton.retrofit.model

class Americano : Coffee {
    override fun recipe(): String = "Expresso, Hot water"
    override fun name(): String = "Caffè Americano"
//    override fun recipe(): String ="recipe Americano"
}