import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.tablayout.FirstTabFragment
import com.example.tablayout.R
import com.example.tablayout.SecondTabFragment
import com.example.tablayout.TabPagerAdapter
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager: ViewPager = findViewById(R.id.view_pager)
        val tabLayout: TabLayout = findViewById(R.id.tab_layout)

        val adapter = TabPagerAdapter(supportFragmentManager)
        adapter.addFragment(FirstTabFragment(), "Tab 1")
        adapter.addFragment(SecondTabFragment(), "Tab 2")

        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }
}
