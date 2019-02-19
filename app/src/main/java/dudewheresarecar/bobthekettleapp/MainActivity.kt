package dudewheresarecar.bobthekettleapp

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.Snackbar
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : FragmentActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up initial home fragment and set action listeners for the bottom nav to switch fragments
        val bottomNavView = findViewById<BottomNavigationView>(R.id.navigation)
        val initHome = Home()
        val initTransaction = supportFragmentManager.beginTransaction()
        initTransaction.replace(R.id.fragment, initHome)
        initTransaction.addToBackStack(null)
        initTransaction.commit()
        bottomNavView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_settings -> {
                    val settings = Settings()
                    val transaction : FragmentTransaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fragment, settings)
                    transaction.addToBackStack(null)
                    transaction.commit()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.action_stats -> {
                    val stats = Stats()
                    val transaction : FragmentTransaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fragment, stats)
                    transaction.addToBackStack(null)
                    transaction.commit()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.action_home -> {
                    val home = Home()
                    val transaction : FragmentTransaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fragment, home)
                    transaction.addToBackStack(null)
                    transaction.commit()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.action_help -> {
                    val help = Help()
                    val transaction : FragmentTransaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fragment, help)
                    transaction.addToBackStack(null)
                    transaction.commit()
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    Log.d("Nothing", "Nothing at all homie")
                    return@setOnNavigationItemSelectedListener true
                }
            }
        }
    }
}
