package cl.awakelab.superheroes.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import cl.awakelab.superheroes.R
import cl.awakelab.superheroes.databinding.ItemLayoutBinding
import cl.awakelab.superheroes.model.data.local.list.HeroEntity
import coil.load

class AdapterList: RecyclerView.Adapter<AdapterList.ViewHolder>() {

    private lateinit var binding: ItemLayoutBinding
    private val listItemHero = mutableListOf<HeroEntity>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listItemHero.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hero = listItemHero[position]
        holder.bind(hero)
    }

    fun setData(heros: List<HeroEntity>){
        this.listItemHero.clear()
        this.listItemHero.addAll(heros)
        notifyDataSetChanged()
    }


    class ViewHolder(val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(hero: HeroEntity) {
            binding.imgItem.load(hero.imagenLink)
            binding.textname.text = hero.nombre
            binding.cardViewItem.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("id", hero.id.toString())
                Navigation.findNavController(binding.root)
                    .navigate(R.id.action_listFragment_to_detailFragment, bundle)
            }

        }

    }
}