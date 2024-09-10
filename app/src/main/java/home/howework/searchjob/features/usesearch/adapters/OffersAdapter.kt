package home.howework.searchjob.features.usesearch.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import home.howework.domain.entities.OffersDto
import home.howework.searchjob.databinding.VacanciesNearListBinding

class OffersAdapter (private val OnItemClick: (String) -> Unit) :
    ListAdapter<OffersDto, OffersHolder>(DiffUtilCallbackOffers()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OffersHolder {
        return OffersHolder(
            VacanciesNearListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OffersHolder, position: Int) {
        val item = getItem(position)
        with(holder.binding) {
            vacanciesNear.text = item.title.toString()

            holder.binding.root.setOnClickListener {
                OnItemClick(item.link.toString())
            }
        }
    }

}

class DiffUtilCallbackOffers : DiffUtil.ItemCallback<OffersDto>() {
    override fun areItemsTheSame(oldItem: OffersDto, newItem: OffersDto): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: OffersDto, newItem: OffersDto): Boolean =
        oldItem == newItem
}

class OffersHolder (val binding: VacanciesNearListBinding) : RecyclerView.ViewHolder(binding.root)
