package com.example.netflixexample.datasource

import com.example.netflixexample.R
import com.example.netflixexample.model.Item

class FakeDateSource {
    fun loadMovies():List<Item> {
        return listOf(
            Item(R.drawable.spiderman),
            Item(R.drawable.spiderman),
            Item(R.drawable.spiderman),
            Item(R.drawable.spiderman),
            Item(R.drawable.spiderman),
            Item(R.drawable.spiderman),
            Item(R.drawable.spiderman),
            Item(R.drawable.spiderman),
            Item(R.drawable.spiderman),
            Item(R.drawable.spiderman),
            Item(R.drawable.spiderman),
            Item(R.drawable.spiderman),
            Item(R.drawable.spiderman),
            Item(R.drawable.spiderman),
            Item(R.drawable.spiderman),
            Item(R.drawable.spiderman),
            Item(R.drawable.spiderman),
            Item(R.drawable.spiderman),
            Item(R.drawable.spiderman),
        )
    }
}