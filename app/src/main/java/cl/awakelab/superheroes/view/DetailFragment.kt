package cl.awakelab.superheroes.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import cl.awakelab.superheroes.R
import cl.awakelab.superheroes.databinding.FragmentDetailBinding
import cl.awakelab.superheroes.viewmodel.HeroViewModel





class DetailFragment : Fragment() {

    lateinit var binding: FragmentDetailBinding
    private val viewModel: HeroViewModel by activityViewModels()

    private var param1: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString("id")

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater)
        initComponents()
        initListeners()
        return binding.root
    }

    private fun initListeners() {
        viewModel.heroDetailLiveData(param1.toString().toLong())
            .observe(viewLifecycleOwner){
                if (it != null){

                }
            }
    }

    private fun initComponents() {
        TODO("Not yet implemented")
    }


}