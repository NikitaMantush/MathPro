package com.mantushnikita.mathpro.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import com.mantushnikita.mathpro.databinding.FragmentSinginBinding
import com.mantushnikita.mathpro.util.openFragment
import com.mantushnikita.mathpro.util.setValidation
import com.mantushnikita.mathpro.util.validation.ValidationResult
import com.mantushnikita.mathpro.util.validation.validateEmail
import com.mantushnikita.mathpro.util.validation.validatePassword

class SingInFragment: Fragment() {

    private var binding: FragmentSinginBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSinginBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.run {
            singInEmailEdit.doAfterTextChanged {
                validate()
            }
            singInPasswordEdit.doAfterTextChanged {
                validate()
            }
            loginButton.setOnClickListener {
                if (validate()){
                    parentFragmentManager.openFragment(MainFragment())
                }
            }
        }
    }
    private fun validate(): Boolean {
        val inputs = binding?.run {
            listOf(
                singInEmailInput to validateEmail(singInEmailInput.editText?.text.toString()),
                singInPasswordInput to validatePassword(singInPasswordInput.editText?.text.toString())
            )
        }
        inputs?.forEach { (input, validation) ->
            input.setValidation(validation)
        }
        return inputs?.all { (_, validation) -> validation is ValidationResult.Valid } ?: false
    }
}