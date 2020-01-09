package com.erikharutyunyan.databindingmvvm.Adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.erikharutyunyan.databindingmvvm.Base.BaseAdapter
import com.erikharutyunyan.databindingmvvm.Base.BaseViewHolder
import com.erikharutyunyan.databindingmvvm.Base.BindAdapter
import com.erikharutyunyan.databindingmvvm.R
import com.erikharutyunyan.databindingmvvm.databinding.ItemUserBinding
import com.erikharutyunyan.databindingmvvm.model.Users


class UserAdapter : BaseAdapter<BaseViewHolder>(),
    BindAdapter<Users> {
    private var context: Context? = null
    private val data: MutableList<Users> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        context = parent.context
        return UserViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.item_user,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val packageHolder = holder as UserViewHolder
        packageHolder.binding.model = data[position]
    }

    class UserViewHolder(val binding: ItemUserBinding) : BaseViewHolder(binding.root)

    override fun setItems(items: List<Users>?) {
        Log.i("packageResponse", items.toString())
        data.clear()
        items?.let { data.addAll(it) }
        notifyDataSetChanged()
    }


}