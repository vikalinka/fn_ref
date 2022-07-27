package lt.vitalikas.fn_ref

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import lt.vitalikas.fn_ref.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val navController by lazy {
        findNavController(R.id.nav_host_fragment_content_main)
    }

    private val toolbar get() = binding.appBarMain.toolbar
    private val navigation get() = binding.navView
    private val drawerLayout get() = binding.drawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {

        // installing splash screen
        val splashScreen = installSplashScreen()

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigation()
        setupToolbar()
    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.main, menu)
//        return true
//    }
//
//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
//    }

    private fun setupNavigation() {
        navigation.setupWithNavController(navController = navController)
    }

    private fun setupToolbar() {
        with(toolbar) {
            /**
             * Passing each menu ID as a set of ids because each
             * menu should be considered as top level destinations.
             */
            val appBarConfiguration = AppBarConfiguration(
                setOf(
                    R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
                ), drawerLayout
            )

            setupWithNavController(
                navController = navController,
                configuration = appBarConfiguration
            )
        }
    }
}
