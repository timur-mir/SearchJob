package home.howework.searchjob.features.useconfirmation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import home.howework.searchjob.databinding.ConfirmationFragmentBinding
class ConfirmationFragment:Fragment() {
    private var _binding: ConfirmationFragmentBinding? = null
    val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ConfirmationFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val arg: ConfirmationFragmentArgs by navArgs()
        val sequrityCode = StringBuilder()
        binding.conformationNotify.text="Отправили код на ${arg.emailText.toString()}"
        binding.editDig2.isCursorVisible = true
        binding.editDig1.requestFocus()
            binding.editDig1.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun afterTextChanged(p0: Editable?) {
                    val digit = binding.editDig1.text
                    if (digit.length == 1) {
                        sequrityCode.append((digit))
                        binding.editDig2.requestFocus()
                        binding.editDig2.isCursorVisible = true
                    } else if (digit.length == 0) {
                        sequrityCode.deleteCharAt(0)
                        binding.editDig1.requestFocus()
                        binding.editDig1.isCursorVisible = true
                    }
                }

            })


            binding.editDig2.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun afterTextChanged(p0: Editable?) {
                    val digit = binding.editDig2.text
                    if (digit.length == 1) {
                        sequrityCode.append((digit))
                        binding.editDig3.requestFocus()
                        binding.editDig3.isCursorVisible = true
                    } else if (digit.length == 0) {
                        sequrityCode.deleteCharAt(0)
                        binding.editDig2.requestFocus()
                        binding.editDig2.isCursorVisible = true
                    }
                }

            })


            binding.editDig3.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun afterTextChanged(p0: Editable?) {
                    val digit = binding.editDig3.text
                    if (digit.length == 1) {
                        sequrityCode.append((digit))
                        binding.editDig4.requestFocus()
                        binding.editDig4.isCursorVisible = true
                    } else if (digit.length == 0) {
                        sequrityCode.deleteCharAt(0)
                        binding.editDig3.requestFocus()
                        binding.editDig3.isCursorVisible = true
                    }
                }


            })

            binding.editDig4.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun afterTextChanged(p0: Editable?) {
                    val digit = binding.editDig4.text
                    if (digit.length == 1) {
                        sequrityCode.append((digit))
                    } else if (digit.length == 0) {
                        sequrityCode.deleteCharAt(0)
                    }


                }
            })
        binding.confirmButton.setOnClickListener {
            if (sequrityCode.length == 4) {
                val action =
                    ConfirmationFragmentDirections.actionConfirmationFragmentToSearchFragment2()
                findNavController().navigate(action)
            }
        }

        }
    }
