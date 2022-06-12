package com.tarea2.ui.Compra

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.tarea2.R
import com.tarea2.databinding.FragmentAddCompraBinding
import com.tarea2.model.Compra
import com.tarea2.viewmodel.CompraViewModel

class AddCompraFragment : Fragment() {

    private var _binding: FragmentAddCompraBinding? = null
    private val binding get() = _binding!!

    private  lateinit var compraViewModel: CompraViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        compraViewModel =
            ViewModelProvider(this).get(CompraViewModel::class.java)

        _binding = FragmentAddCompraBinding.inflate(inflater, container, false)

        binding.btAgregar.setOnClickListener {
            addCompra()
        }

        return  binding.root
    }

    private fun addCompra() {
        val nombre = binding.etNombre.text.toString()
        val correo = binding.etCorreo.text.toString()
        val telefono = binding.etTelefono.text.toString()
        val web = binding.etWeb.text.toString()
        val cantidad = binding.etCantidad.text.toString()
        val precio = binding.etPrecio.text.toString()
        if (nombre.isNotEmpty()) { // si puedo crear un lugar
            val compra = Compra(0,nombre,correo,telefono,web,cantidad,precio,"")
            compraViewModel.addCompra(compra)
            Toast.makeText(requireContext(),getString(R.string.msg_compra_added), Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addCompraFragment_to_nav_compra)

        }else { // mensaje de error
            Toast.makeText(requireContext(),getString(R.string.msg_data), Toast.LENGTH_SHORT).show()

        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}