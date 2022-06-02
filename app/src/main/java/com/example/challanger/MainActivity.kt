package com.example.challanger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AutoCompleteTextView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.graphics.toColor
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout
    lateinit var toolbar: Toolbar
    lateinit var welcomeTextView: TextView
    lateinit var navView: NavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        welcomeTextView = findViewById(R.id.welcome_text)
        toolbar = findViewById(R.id.toolbar)
        drawerLayout = findViewById(R.id.drawerLayout)
        navView= findViewById(R.id.nav_view)
        toolbar.inflateMenu(R.menu.toolbar_menu)
        toggle = ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close)
        toggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()


        navView.setNavigationItemSelectedListener {
            welcomeTextView.visibility = View.GONE
            it.isCheckable=true

            when(it.itemId){
                R.id.nav_home -> replaceFragment(HomeFragment(),it.title.toString())
                R.id.nav_menu_1 -> replaceFragment(FirstFragment(),it.title.toString())
                R.id.nav_menu_2 -> replaceFragment(SecendFragment(),it.title.toString())
                R.id.nav_menu_3 -> Toast.makeText(applicationContext,"Kliknięto 3",Toast.LENGTH_SHORT).show()
                R.id.nav_menu_5 -> Toast.makeText(applicationContext,"Kliknięto 5",Toast.LENGTH_SHORT).show()

            }
            true
        }
        toolbar.setOnMenuItemClickListener {
            welcomeTextView.visibility = View.GONE
            it.isCheckable=true
            when(it.itemId){
                R.id.hot -> replaceFragment(HotFragment(),it.title.toString())
                R.id.tobeyond -> Toast.makeText(applicationContext,"To beyond!",Toast.LENGTH_SHORT).show()
            }
            true
        }

    }



    private fun replaceFragment(fragment: Fragment, title:String){
        val fragmentMenager = supportFragmentManager
        val fragmentTransaction = fragmentMenager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()
        drawerLayout.closeDrawers()
        setTitle(title)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)){
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return true
    }


}