package com.example.medilab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    private lateinit var bottomNavigation: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        bottomNavigation = findViewById(R.id.bottom_navigation)
        bottomNavigation.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.home -> { replaceFragment(HomeFragment()) }
                R.id.profile -> { replaceFragment(ProfileFragment()) }
                R.id.add_dependant -> { replaceFragment(AddDependantFragment())}
                R.id.cart -> { replaceFragment(CartFragment()) }
            } // end when
            true
        } // end listener

        replaceFragment(HomeFragment())
    } // end onCreate

    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit()
    }

}