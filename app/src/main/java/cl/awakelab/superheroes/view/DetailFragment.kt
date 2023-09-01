package cl.awakelab.superheroes.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import cl.awakelab.superheroes.R
import cl.awakelab.superheroes.databinding.FragmentDetailBinding
import cl.awakelab.superheroes.viewmodel.HeroViewModel
import coil.load


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

    private fun initComponents() {
        viewModel.getHeroDetailsViewModel(param1.toString().toInt())
        viewModel.heroDetailLiveData(param1.toString().toInt()).observe(viewLifecycleOwner) {
            if (it != null) {
                binding.imgDetail.load(it.imagenLink)
                binding.txtNombreDetail.text = it.nombre
                binding.txtOrigen.text = it.origen
                binding.txtAnioCreacion.text = it.anioCreacion.toString()
                binding.txtPoder.text = it.poder
                binding.txtColor.text = it.color
                if (!it.traduccion) {
                    binding.txtTraduccion.text = getString(R.string.sin_traduccion)
                } else {
                    binding.txtTraduccion.text = getString(R.string.cuenta_con_traduccion_al_español)
                }
            }
        }
    }

    private fun initListeners() {
        viewModel.heroDetailLiveData(param1.toString().toInt())
            .observe(viewLifecycleOwner) {
                if (it != null) {
                    val asunto = "Consulta ${it.nombre} id ${it.id}"
                    val message =
                        "Hola, Quiero que el siguiente super héroes ${it.nombre}aparezca, en la nueva edición de \n" +
                                "biografías animadas. \n" +
                                "Número contacto: _________\n" +
                                "Gracias."


                    binding.floatingActionButton.setOnClickListener {
                        val mail = "info@prueba.cl"
                        val intentMail = Intent(Intent.ACTION_SEND, Uri.parse(mail))
                        intentMail.type = "text/plain"
                        intentMail.putExtra(Intent.EXTRA_EMAIL, arrayOf(mail))
                        intentMail.putExtra(Intent.EXTRA_SUBJECT, asunto)
                        intentMail.putExtra(Intent.EXTRA_TEXT, message)
                        startActivity(Intent.createChooser(intentMail, "Send Mail"))
                    }
                }
            }
    }

}