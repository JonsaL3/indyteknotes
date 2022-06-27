package es.indytek.indyteknotes.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import es.indytek.indyteknotes.R
import es.indytek.indyteknotes.databinding.FragmentMainMenuBinding
import es.indytek.indyteknotes.ui.viewmodels.MainViewModel

class MainMenuFragment : Fragment() {

    private lateinit var binding: FragmentMainMenuBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main_menu, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*binding.botonIrAFragmento2.setOnClickListener {
            // val accion = MainMenuFragmentDirections.actionMainMenuFragmentToListaNotasFragment("pepote")
            val accion = MainMenuFragmentDirections.actionMainMenuFragmentToListaNotasFragment()
            it.findNavController().navigate(accion)
        }*/
        cargarListeners()
        viewModel.listaDeNotas.value?.forEach {
            Log.d(":::", it.toString())
        }
    }

    private fun cargarListeners() {

        binding.cardviewNotas.setOnClickListener {
            cargarListaNotasFragment()
        }

        binding.cardviewTareas.setOnClickListener {

        }

    }

    private fun cargarListaNotasFragment() {
        val action = MainMenuFragmentDirections.actionMainMenuFragmentToListaNotasFragment()
        findNavController().navigate(action)
    }

}