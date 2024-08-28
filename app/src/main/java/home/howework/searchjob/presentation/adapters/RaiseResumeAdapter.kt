package home.howework.searchjob.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import home.howework.searchjob.databinding.RaiseResumeListBinding
import home.howework.searchjob.data.mocknetwork.model.OffersMain

class RaiseResumeAdapter (private val OnItemClick: (link: String) -> Unit):
    AbsListItemAdapterDelegate<OffersMain.ResumeRaise, OffersMain, RaiseResumeAdapter.RaiseResumeAdapterHolder>() {


    class RaiseResumeAdapterHolder (val binding:RaiseResumeListBinding ): RecyclerView.ViewHolder(binding.root)

    override fun isForViewType(
        item: OffersMain,
        items: MutableList<OffersMain>,
        position: Int
    ): Boolean {
        return item is OffersMain.ResumeRaise
    }

    override fun onCreateViewHolder(parent: ViewGroup): RaiseResumeAdapterHolder {
        return RaiseResumeAdapter.RaiseResumeAdapterHolder(
            RaiseResumeListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(
        item: OffersMain.ResumeRaise,
        holder: RaiseResumeAdapterHolder,
        payloads: MutableList<Any>
    ) {
        with(holder.binding) {
            raiseResume.text = item.title.toString()
            holder.binding.root.setOnClickListener {
                OnItemClick(item.link.toString())
            }
        }
    }

}