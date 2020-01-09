package com.erikharutyunyan.databindingmvvm.Base

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView


@BindingAdapter("recyclerAdapter")
 fun setRecyclerAdapter(
    recyclerView: RecyclerView,
    adapter: RecyclerView.Adapter<*>
) {
    recyclerView.adapter = adapter
}

@BindingAdapter("recyclerData")
fun <T> setRecyclerItems(recyclerView: RecyclerView, items: List<T>?) {
    if (recyclerView.adapter is BindAdapter<*>) {
        (recyclerView.adapter as BindAdapter<T>).setItems(items)
    }
}
