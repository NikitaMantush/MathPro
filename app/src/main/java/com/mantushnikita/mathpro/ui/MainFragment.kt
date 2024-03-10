package com.mantushnikita.mathpro.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mantushnikita.mathpro.R
import com.mantushnikita.mathpro.databinding.FragmentMainBinding
import com.mantushnikita.mathpro.util.openFragmentWithBottomMenu

class MainFragment : Fragment() {
    private var binding: FragmentMainBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        childFragmentManager.openFragmentWithBottomMenu(ProfileFragment())
        binding?.bottomNavigationView?.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.calculator ->{
                    childFragmentManager
                        .openFragmentWithBottomMenu(CalculatorFragment())
                    return@setOnItemSelectedListener true
                }
                R.id.messenger ->{
                    childFragmentManager
                        .openFragmentWithBottomMenu(MessengerFragment())
                    return@setOnItemSelectedListener true
                }
                R.id.profile ->{
                    childFragmentManager
                        .openFragmentWithBottomMenu(ProfileFragment())
                    return@setOnItemSelectedListener true
                }
                else ->{
                    return@setOnItemSelectedListener false
                }
            }
        }
    }
}