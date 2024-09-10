package home.howework.searchjob.features.uselogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import home.howework.searchjob.R

import home.howework.searchjob.databinding.ActivityMainBinding
import home.howework.searchjob.features.uselogin.MainActivity.BottomPanel.panelNav

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bottomNavigationView = binding.panelNavigationMain
        val navController = findNavController(home.howework.searchjob.R.id.frag_cont)
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

                R.id.responsesFragment -> {
                    if (navController.currentDestination!!.id != R.id.confirmationFragment &&navController.currentDestination!!.id != R.id.loginFragment) {
                        navController.popBackStack()
                        navController.navigate(R.id.responsesFragment)
                    }
                }

                R.id.messageFragment -> {
                    if (navController.currentDestination!!.id != R.id.confirmationFragment &&navController.currentDestination!!.id != R.id.loginFragment) {
                        navController.popBackStack()
                        navController.navigate(R.id.messageFragment2)
                    }

                }

                R.id.profileFragment -> {
                    if (navController.currentDestination!!.id != R.id.confirmationFragment &&navController.currentDestination!!.id != R.id.loginFragment) {
                        navController.popBackStack()
                        navController.navigate(R.id.profileFragment2)
                    }

                }

            }
            true
        }
    }

    object BottomPanel {
        lateinit var panelNav: BottomNavigationView
    }
}