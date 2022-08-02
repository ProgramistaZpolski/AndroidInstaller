package pl.thinktrue.androidinstaller

import android.app.*
import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import androidx.core.content.ContextCompat.getSystemService
import androidx.navigation.fragment.findNavController
import pl.thinktrue.androidinstaller.databinding.FragmentSecondBinding
/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var progressBar: ProgressBar? = null
    private var i = 0
    private val handler = Handler()
    private var probutton: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progressBar = view.findViewById<ProgressBar>(R.id.progressBar) as ProgressBar

        progressBar!!.visibility = View.VISIBLE

        i = progressBar!!.progress

        Thread(Runnable {
            // this loop will run until the value of i becomes 99
            while (i < 100) {
                i += 1
                // Update the progress bar and display the current value
                handler.post(Runnable {
                    progressBar!!.progress = i
                })
                try {
                    Thread.sleep(100)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }

            // setting the visibility of the progressbar to invisible
            // or you can use View.GONE instead of invisible
            // View.GONE will remove the progressbar
            progressBar!!.visibility = View.INVISIBLE

        }).start()

        Handler(Looper.getMainLooper()).postDelayed(
            {
                findNavController().navigate(R.id.action_SecondFragment_to_SystemDestroyedFragment)
            },
            10300 // value in milliseconds
        )

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_SystemDestroyedFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}