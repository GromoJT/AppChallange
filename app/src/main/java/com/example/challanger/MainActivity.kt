package com.example.challanger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.graphics.toColor
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title ="TESTER"

        val drawerLayout : DrawerLayout = findViewById(R.id.drawerLayout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)

        drawerLayout.addDrawerListener(toggle)

        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> Toast.makeText(applicationContext,"Kliknięto dom",Toast.LENGTH_SHORT).show()
                R.id.nav_menu_1 -> Toast.makeText(applicationContext,"Kliknięto 1",Toast.LENGTH_SHORT).show()
                R.id.nav_menu_2 -> Toast.makeText(applicationContext,"Kliknięto 2",Toast.LENGTH_SHORT).show()
                R.id.nav_menu_3 -> Toast.makeText(applicationContext,"Kliknięto 3",Toast.LENGTH_SHORT).show()
                R.id.nav_menu_5 -> Toast.makeText(applicationContext,"Kliknięto 5",Toast.LENGTH_SHORT).show()

            }
            true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)){
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}