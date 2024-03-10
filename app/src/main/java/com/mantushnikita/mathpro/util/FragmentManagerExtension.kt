package com.mantushnikita.mathpro.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.mantushnikita.mathpro.R

fun FragmentManager.openFragment(fragment: Fragment) {
    this.beginTransaction()
        .replace(R.id.container, fragment)
        .commit()
}

fun FragmentManager.openFragment(fragment: Fragment, tag: String) {
    this.beginTransaction()
        .replace(R.id.container, fragment)
        .addToBackStack(tag)
        .commit()
}
fun FragmentManager.openFragmentWithBottomMenu(fragment: Fragment) {
    this.beginTransaction()
        .replace(R.id.child_container, fragment)
        .commit()
}