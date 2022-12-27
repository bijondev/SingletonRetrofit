package com.bijondev.singleton.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.bijondev.singleton.retrofit.model.Coffee
import com.bijondev.singleton.retrofit.model.CoffeeFactory

class MainActivity : AppCompatActivity() {
    private var isChanged: Boolean =false

    var coffee_recipe: TextView?=null
    var coffee_name:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val coffee_btn: Button?=findViewById(R.id.coffee_btn)
        coffee_recipe=findViewById(R.id.coffee_recipe)
        coffee_name=findViewById(R.id.coffee_name)

        coffee_btn!!.setOnClickListener(this::changeCoffee)
    }

    fun changeCoffee(view: View){
        var factory: Coffee
        if (isChanged){
            factory = CoffeeFactory.getCoffee(CoffeeFactory.Type.AMERICANO)
            isChanged = false
        }else{
            factory = CoffeeFactory.getCoffee(CoffeeFactory.Type.LATTE)
            isChanged = true
        }

        changeCoffeeType(factory.recipe(), factory.name())
    }

    private fun changeCoffeeType(recipe: String, name: String){

        coffee_recipe!!.text = recipe

        coffee_name!!.text =name
    }


}