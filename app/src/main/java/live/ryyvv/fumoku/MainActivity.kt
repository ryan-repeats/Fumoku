package live.ryyvv.fumoku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomappbar.BottomAppBar
import com.mikepenz.aboutlibraries.LibsBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val topAppBar = findViewById<Toolbar>(R.id.topAppBar)
        setSupportActionBar(topAppBar)

        val bottomAppBar = findViewById<BottomAppBar>(R.id.bottomAppBar)
        bottomAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.about -> {
                    LibsBuilder()
                        .withAboutAppName(resources.getString(R.string.app_name))
                        .withAboutIconShown(true)
                        .withAboutVersionShown(true)
                        .start(this)
                    true
                }

                else -> false
            }
        }
    }
}