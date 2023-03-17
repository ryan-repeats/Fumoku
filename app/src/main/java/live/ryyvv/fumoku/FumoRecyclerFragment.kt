package live.ryyvv.fumoku

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.ktx.Firebase
import live.ryyvv.fumoku.utils.Fumo

class FumoRecyclerFragment(private val database: DatabaseReference) : Fragment() {
    private lateinit var adapter: FumoAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fumo_recycler, container, false).also {
            val recycler = it as RecyclerView

            val query = database.child(Firebase.auth.uid!!).child("fumo")
            val options = FirebaseRecyclerOptions.Builder<Fumo>()
                .setQuery(query, Fumo::class.java)
                .setLifecycleOwner(this)
                .build()
            adapter = FumoAdapter(options)

            recycler.adapter = adapter
        }
    }
}