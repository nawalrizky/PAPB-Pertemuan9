package com.example.tugas_pertemuan9

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.tugas_pertemuan9.databinding.FragmentOrderBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [OrderFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OrderFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentOrderBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOrderBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }
    fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
        val action = OrderFragmentDirections.actionOrderFragmentToCheckoutFragment()
            btnBuy.setOnClickListener{
                findNavController().navigate(action)
            }
            val jenisTiketObserver = findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<String>("jenis_tiket")
            jenisTiketObserver?.observe(viewLifecycleOwner) { selectedJenisTiket ->
                textJenisTiket.text = selectedJenisTiket.toEditable()
            }
        }
    }


}