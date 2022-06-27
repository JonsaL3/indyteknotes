package es.indytek.indyteknotes.ui.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.indytek.indyteknotes.model.Nota
import java.time.LocalDateTime

class MainViewModel : ViewModel() {

    // datos que necesito manipular dentro del viewmodel y ver fuera de el
    private var _listaDeNotas = MutableLiveData<ArrayList<Nota>>()
    val listaDeNotas: LiveData<ArrayList<Nota>>
        get() = _listaDeNotas

    // Metodos de manipulación y acceso a los datos
    private fun cargarNotas() {
        val lista = ArrayList<Nota>()
        lista.apply {
            add(Nota(1, "Nota 1", "Las cronicas de narnia", LocalDateTime.now(), 1))
            /*add(Nota(2, "Nota 2", "Las cronicas de narnia", LocalDateTime.now(), 1))
            add(Nota(3, "Nota 3", "Las cronicas de narnia", LocalDateTime.now(), 1))
            add(Nota(4, "Nota 4", "Las cronicas de narnia", LocalDateTime.now(), 1))
            add(Nota(5, "Nota 5", "Las cronicas de narnia", LocalDateTime.now(), 1))
            add(Nota(6, "Nota 6", "Las cronicas de narnia", LocalDateTime.now(), 1))
            add(Nota(7, "Nota 7", "Las cronicas de narnia", LocalDateTime.now(), 1))
            add(Nota(8, "Nota 8", "Las cronicas de narnia", LocalDateTime.now(), 1))*/
        }
        _listaDeNotas.value = lista
    }

    // cosas que hago al principio y al final del viewmodel
    init {
        Log.d(":::MainViewModel", "ViewModel CREADO")
        cargarNotas()
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(":::MainViewModel", "ViewModel ELIMINADO")
    }

}