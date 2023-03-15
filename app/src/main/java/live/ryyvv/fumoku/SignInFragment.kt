package live.ryyvv.fumoku

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class SignInFragment(private val l: View.OnClickListener) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sign_in, container, false).apply {
            findViewById<Button>(R.id.button).setOnClickListener(l)
        }
    }
}