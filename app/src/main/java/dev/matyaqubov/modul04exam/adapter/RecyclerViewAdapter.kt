package dev.matyaqubov.modul04exam.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.matyaqubov.modul04exam.R
import dev.matyaqubov.modul04exam.model.Food

class RecyclerViewAdapter(var content:Context,var foods:ArrayList<Food>) :RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view= LayoutInflater.from(parent.context).inflate(R.layout.item_foods,parent,false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val food=foods[position]

        if (holder is FoodViewHolder){
            holder.image.setImageResource(food.image)
            holder.name.text=food.name
            holder.describtion.text=food.describtion
            holder.prise.text=food.prise
            holder.stars.rating= food.star.toFloat()

        }
    }

    override fun getItemCount(): Int {
        return foods.size
    }


    class FoodViewHolder(view:View):RecyclerView.ViewHolder(view){

        val image=view.findViewById<ImageView>(R.id.img_food)
        val name=view.findViewById<TextView>(R.id.tv_foodname)
        val prise=view.findViewById<TextView>(R.id.tv_food_prise)
        val stars=view.findViewById<RatingBar>(R.id.rating)
        val describtion=view.findViewById<TextView>(R.id.tv_describtion)

    }
}