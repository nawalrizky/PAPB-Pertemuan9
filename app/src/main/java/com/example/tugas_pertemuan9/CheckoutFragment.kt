package com.example.tugas_pertemuan9

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.example.tugas_pertemuan9.databinding.FragmentCheckoutBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CheckoutFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CheckoutFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentCheckoutBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCheckoutBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            val jenisTiketArray = resources.getStringArray(R.array.jenis_tiket)
            val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, jenisTiketArray)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerJenisTiket.adapter = adapter

            btnCheckout.setOnClickListener {
                val selectedJenisTiket = spinnerJenisTiket.selectedItem.toString()

                findNavController().previousBackStackEntry?.savedStateHandle?.set("jenis_tiket", selectedJenisTiket)
                findNavController().navigateUp()
            }
        }
    }


}