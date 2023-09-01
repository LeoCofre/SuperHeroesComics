package cl.awakelab.superheroes.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView.Adapter
import cl.awakelab.superheroes.R
import cl.awakelab.superheroes.databinding.FragmentListBinding
import cl.awakelab.superheroes.viewmodel.HeroViewModel

class ListFragment : Fragment() {

    lateinit var binding: FragmentListBinding
    private val viewModel: HeroViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(layoutInflater)
        initAdapter()
        return binding.root
    }

    private fun initAdapter() {
        viewModel.getHeroViewModel()
        val adapter = AdapterList()
        binding.recyclerList.adapter = adapter
        viewModel.herosLiveData().observe(viewLifecycleOwner){
            adapter.setData(it)
        }
    }


}