package live.ryyvv.fumoku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomappbar.BottomAppBar

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
                    startActivity(
                        Intent(
                            this,
                            AboutActivity::class.java
                        )
                    )
                    true
                }

                else -> false
            }
        }
    }
}