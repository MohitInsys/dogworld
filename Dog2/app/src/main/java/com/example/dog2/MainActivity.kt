package com.example.dog2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

import com.example.dog2.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity:AppCompatActivity() {
           private lateinit var navController: NavController
            lateinit var binding:ActivityMainBinding
          // private var bottomNavigationView: BottomNavigationView?=null
            lateinit var appBarConfiguration: AppBarConfiguration
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                binding = ActivityMainBinding.inflate(layoutInflater)
                setContentView(binding.root)

               /* val bottomNavigationView=findViewById<BottomNavigationView>(R.id.navBar)
                bottomNavigationView.setupWithNavController(navController)*/

                val navHostFrag=supportFragmentManager.findFragmentById(R.id.homefrag) as NavHostFragment
                navController=navHostFrag.navController
                val bottomNavigationView=findViewById<BottomNavigationView>(R.id.navBar)
                bottomNavigationView.setupWithNavController(navController)

              /*  appBarConfiguration= AppBarConfiguration(setOf(R.id.navigation_home,R.id.favourite,R.id.setting,R.id.profile))
                setupActionBarWithNavController(navController,appBarConfiguration)
                bottomNavigationView?.setupWithNavController(navController)*/
            }
}



