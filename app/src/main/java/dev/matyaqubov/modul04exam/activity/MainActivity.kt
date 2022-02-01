package dev.matyaqubov.modul04exam.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.matyaqubov.modul04exam.R
import dev.matyaqubov.modul04exam.adapter.RecyclerViewAdapter
import dev.matyaqubov.modul04exam.model.Food

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var foods:ArrayList<Food>
    private lateinit var recyclerViewAdapter:RecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        recyclerView=findViewById(R.id.rv_main)
        prepareFoodList()
        recyclerViewAdapter= RecyclerViewAdapter(this,foods)
        //recyclerView.layoutManager=GridLayoutManager(this,1)


        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val gridLayoutManager = recyclerView.getLayoutManager() as GridLayoutManager
                val totalItem = gridLayoutManager.itemCount
                val lastVisible = gridLayoutManager.findLastVisibleItemPosition()
                val endHasBeenReached = lastVisible + 5 >= totalItem
                if (totalItem > 0 && endHasBeenReached) {
                    loadMoreFoods()
                    recyclerViewAdapter.notifyDataSetChanged();
                }
            }
        })

        recyclerView.adapter=recyclerViewAdapter
    }

    private fun prepareFoodList() {
        foods= ArrayList()
        foods.add(Food(R.drawable.american_xotdog,"American Xotdog","12$",4.1,"America * Deli"))
        foods.add(Food(R.drawable.burger,"American burger","20$",3.5,"America * Choli"))
        foods.add(Food(R.drawable.casey_lee,"Britian Lee","15$",4.0,"London * Chapa"))
        foods.add(Food(R.drawable.danar,"Uzbek Danari","10$",5.0,"Uzbekistan * Chorsu"))
        foods.add(Food(R.drawable.egg,"Karvak eggs","5$",5.0,"Uzbekistan * Karvak"))
        foods.add(Food(R.drawable.gilly,"Italian Gilly","22$",3.5,"Italy * Italy"))
        foods.add(Food(R.drawable.jay_wennington,"Vashington Jay","16.5$",3.0,"USA * Vashington"))



    }

    private fun loadMoreFoods(){
        foods.add(Food(R.drawable.american_xotdog,"American Xotdog","12$",4.1,"America * Deli"))
        foods.add(Food(R.drawable.burger,"American burger","20$",3.5,"America * Choli"))
        foods.add(Food(R.drawable.casey_lee,"Britian Lee","15$",4.0,"London * Chapa"))
        foods.add(Food(R.drawable.danar,"Uzbek Danari","10$",5.0,"Uzbekistan * Chorsu"))
        foods.add(Food(R.drawable.egg,"Karvak eggs","5$",5.0,"Uzbekistan * Karvak"))
        foods.add(Food(R.drawable.gilly,"Italian Gilly","22$",3.5,"Italy * Italy"))
        foods.add(Food(R.drawable.jay_wennington,"Vashington Jay","16.5$",3.0,"USA * Vashington"))


    }
}