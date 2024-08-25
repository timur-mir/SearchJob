package home.howework.searchjob.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import home.howework.searchjob.R
import home.howework.searchjob.databinding.ActivityMainBinding
import home.howework.searchjob.presentation.MainActivity.BottomPanel.panelNav

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bottomNavigationView = binding.panelNavigationMain
        val navController = findNavController(R.id.frag_cont)
        bottomNavigationView.setupWithNavController(navController)
        panelNav = bottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener { it ->
            when (it.itemId) {

                R.id.searchFragment -> {
                    if (navController.currentDestination!!.id != R.id.confirmationFragment &&navController.currentDestination!!.id != R.id.loginFragment ) {
                        navController.popBackStack()
                        navController.navigate(R.id.searchFragment2)
                    }

                }

                R.id.favoriteFragment -> {
                    if (navController.currentDestination!!.id != R.id.confirmationFragment &&navController.currentDestination!!.id != R.id.loginFragment ) {
                       navController.popBackStack()
                        navController.navigate(R.id.favoriteFragment2)
                    }
                }

                R.id.responseFragment -> {

                }

                R.id.messageFragment -> {

                }

                R.id.profileFragment -> {

                }

            }
            true
        }
    }

    object BottomPanel {
        lateinit var panelNav: BottomNavigationView
    }
}