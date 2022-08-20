package com.example.shakil.utils

import com.example.shakil.R

open class NavigationItems(var route: String, var icon: Int, var title: String) {
    object home : NavigationItems("home", R.drawable.ic_baseline_home_24 , "Home")
    object search : NavigationItems("search", R.drawable.ic_baseline_search_24 , "Search")
    object addPost : NavigationItems("addPost", R.drawable.ic_outline_add_box_24 , "Add Post")
    object activity : NavigationItems("activity", R.drawable.ic_baseline_favorite_border_24 , "Activity")
    object profile : NavigationItems("profile", R.drawable.ic_baseline_person_24 , "Profile")
}