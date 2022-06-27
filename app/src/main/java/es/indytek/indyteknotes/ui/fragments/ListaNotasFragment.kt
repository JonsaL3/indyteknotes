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
import androidx.navigation.fragment.navArgs
import es.indytek.indyteknotes.R
import es.indytek.indyteknotes.databinding.FragmentListaNotasBinding
import es.indytek.indyteknotes.ui.viewmodels.MainViewModel

class ListaNotasFragment : Fragment() {

    private lateinit var binding: FragmentListaNotasBinding
    // private val args: ListaNotasFragmentArgs by navArgs()
    private val viewModel: MainViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_lista_notas, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*// binding.botonIrAFragmento1.text = args.nombre
        binding.botonIrAFragmento1.setOnClickListener {
            val accion = ListaNotasFragmentDirections.actionListaNotasFragmentToMainMenuFragment()
            it.findNavController().navigate(accion)
        }*/
        viewModel.listaDeNotas.value?.forEach {
            Log.d(":::", it.toString())
        }
    }

}