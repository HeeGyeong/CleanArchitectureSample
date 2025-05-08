package com.example.cleanarchitecturestudy.view.example.compose

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.cleanarchitecturestudy.R

class SecondFragment : Fragment() {

    private var fragmentSwitchListener: FragmentSwitchListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btn_switch_to_first).setOnClickListener {
            fragmentSwitchListener?.switchToFirstFragment()
        }
    }

    fun setFragmentSwitchListener(listener: FragmentSwitchListener) {
        fragmentSwitchListener = listener
    }

    interface FragmentSwitchListener {
        fun switchToFirstFragment()
    }

    companion object {
        fun newInstance(): SecondFragment {
            return SecondFragment()
        }
    }
} 