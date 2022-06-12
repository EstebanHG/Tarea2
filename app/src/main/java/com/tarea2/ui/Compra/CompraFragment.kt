package com.tarea2.ui.Compra

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.tarea2.R
import com.tarea2.databinding.FragmentCompraBinding
import com.tarea2.viewmodel.CompraViewModel

class CompraFragment : Fragment() {

    private var _binding: FragmentCompraBinding? = null
    private val binding get() = _binding!!

    private  lateinit var compraViewModel: CompraViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val compraViewModel =
            ViewModelProvider(this).get(CompraViewModel::class.java)

        _binding = FragmentCompraBinding.inflate(inflater, container, false)

        binding.addCompra.setOnClickListener {
            findNavController().navigate(R.id.action_nav_compra_to_addCompraFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}