package live.ryyvv.fumoku

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import live.ryyvv.fumoku.utils.Fumo

class FumoAdapter(options: FirebaseRecyclerOptions<Fumo>) :
    FirebaseRecyclerAdapter<Fumo, FumoAdapter.ViewHolder>(options) {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView

        val name: TextView
        val type: TextView
        val story: TextView

        val delete: Button

        init {
            with(view) {
                image = findViewById(R.id.image)

                name = findViewById(R.id.name)
                type = findViewById(R.id.type)
                story = findViewById(R.id.story)

                delete = findViewById(R.id.delete)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fumo_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, model: Fumo) {
        with(holder) {
            // Name should be the Fumo type if the user didn't input a custom name.
            // I also don't know what in carnation happening here.
            name.text = model.name?.run {
                type.run {
                    text = model.type
                    visibility = View.VISIBLE
                }
                this
            } ?: model.type

            story.text = model.story

            delete.setOnClickListener {
                CoroutineScope(Dispatchers.IO).launch {
                    getRef(position).removeValue().await()
                }
            }
        }
    }
}