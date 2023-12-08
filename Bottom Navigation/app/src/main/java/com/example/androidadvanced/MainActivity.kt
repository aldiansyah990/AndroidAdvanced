import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnItemSelectedListener { menuItem ->
        when (menuItem.itemId) {
            R.id.navigation_home -> {
                replaceFragment(HomeFragment())
                return@OnItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                replaceFragment(DashboardFragment())
                return@OnItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                replaceFragment(NotificationsFragment())
                return@OnItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        supportActionBar?.title = "Toolbar Title"

        bottom_navigation.setOnItemSelectedListener(onNavigationItemSelectedListener)

        // Show the first fragment when the app is opened
        replaceFragment(HomeFragment())
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_container, fragment)
            .commit()
    }
}
