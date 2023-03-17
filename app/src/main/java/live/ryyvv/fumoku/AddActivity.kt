package live.ryyvv.fumoku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import live.ryyvv.fumoku.utils.Fumo

class AddActivity : AppCompatActivity() {
    lateinit var name: TextInputLayout
    lateinit var type: TextInputLayout
    lateinit var story: TextInputLayout

    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        findViewById<Toolbar>(R.id.topAppBar).apply {
            setSupportActionBar(this)

            setNavigationOnClickListener {
                finish()
            }
        }

        name = findViewById(R.id.name)
        type = findViewById(R.id.type)
        story = findViewById(R.id.story)

        auth = Firebase.auth
        database = Firebase.database

        findViewById<ExtendedFloatingActionButton>(R.id.submit).apply {
            setOnClickListener {
                database.reference.child(auth.uid!!).child("fumo").push().setValue(
                    getFumo()
                )

                setResult(RESULT_OK)
                finish()
            }
        }
    }

    fun getFumo(): Fumo {
        val name = name.editText!!.text.toString()
        val type = type.editText!!.text.toString()
        val story = story.editText!!.text.toString()

        return Fumo(
            name.ifEmpty { null },
            type,
            story,
        )
    }
}