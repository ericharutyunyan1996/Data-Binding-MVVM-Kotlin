package com.erikharutyunyan.databindingmvvm.Fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.erikharutyunyan.databindingmvvm.R
import com.erikharutyunyan.databindingmvvm.databinding.FragmentMainBinding
import com.erikharutyunyan.databindingmvvm.viewmodel.UserViewModel

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {
    private lateinit var viewModel: UserViewModel
    private lateinit var dataBinding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this)[UserViewModel::class.java]
        dataBinding = DataBindingUtil.inflate<FragmentMainBinding>(LayoutInflater.from(context!!), R.layout.fragment_main, null, false).apply {
            usersViewModel = viewModel
            lifecycleOwner = viewLifecycleOwner
        }
        return dataBinding.root
    }
    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getUsers(context!!)
    }

}
