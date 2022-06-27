package es.indytek.indyteknotes.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

object Utils {

    fun cambiarDeFragmentoGuardandoElAnterior(
        fragmentManager: FragmentManager,
        fragment: Fragment,
        tag: String = "fragAnterior",
        container: Int
    ) {
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(container, fragment, tag)
        fragmentTransaction.addToBackStack(tag)
        fragmentTransaction.commit()
    }

}