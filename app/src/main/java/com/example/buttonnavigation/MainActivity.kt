package com.example.buttonnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.buttonnavigation.fragment.HomeFragment
import com.example.buttonnavigation.fragment.NotificationFragment
import com.example.buttonnavigation.fragment.SettingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homefragment = HomeFragment()
        val notificationfragment = NotificationFragment()
        val settingfragment = SettingFragment()

        makeCurrentFragment (homefragment)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottom_navigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.menu_home -> makeCurrentFragment(homefragment)
                R.id.menu_notification -> makeCurrentFragment(notificationfragment)
                R.id.menu_setting -> makeCurrentFragment(settingfragment)
            }

            true
        }



    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fram_nav, fragment)
            commit()
        }

    }
}