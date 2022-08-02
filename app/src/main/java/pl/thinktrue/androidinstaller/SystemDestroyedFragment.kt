package pl.thinktrue.androidinstaller

import android.app.*
import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.content.ContextCompat.getSystemService
import androidx.navigation.fragment.findNavController
import pl.thinktrue.androidinstaller.databinding.FragmentSystemDestroyedBinding
/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SystemDestroyedFragment : Fragment() {

    private var _binding: FragmentSystemDestroyedBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSystemDestroyedBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}