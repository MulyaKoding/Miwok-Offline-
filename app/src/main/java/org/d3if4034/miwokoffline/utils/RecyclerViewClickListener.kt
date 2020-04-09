package org.d3if4034.miwokoffline.utils

import android.view.View
import org.d3if4034.miwokoffline.model.Miwok

interface RecyclerViewClickListener {

    fun onRecyclerViewItemClicked(view: View, miwok: Miwok) {}

}