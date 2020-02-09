package com.test.validateiban.ui.routingcode

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.test.validateiban.R
import com.test.validateiban.databinding.FragmentRoutingCodesItemBinding
import com.test.validateiban.ui.routingcode.model.Bic

/**
 * [RecyclerView.Adapter] that can display a [Bic]
 */
class RoutingCodesRecyclerViewAdapter(private val itemListener: RoutingCodesItemListener) : RecyclerView.Adapter<RoutingCodesRecyclerViewAdapter.ViewHolder>() {

    private lateinit var context: Context
    private lateinit var bicList: List<Bic>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<FragmentRoutingCodesItemBinding>(layoutInflater, R.layout.fragment_routing_codes_item, parent, false)
        context = parent.context
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = bicList[position]
        holder.binding.tvName.text = item.bankName
        holder.binding.tvLocation.text = item.location
        holder.binding.tvBicCode.text = item.bicCode
        holder.binding.codes = item
        holder.itemView.setOnClickListener{
            itemListener.onRoutingCodeItemClick(item)
        }
    }

    override fun getItemCount(): Int {
        return if (::bicList.isInitialized) bicList.size else 0
    }

    inner class ViewHolder(val binding: FragmentRoutingCodesItemBinding) : RecyclerView.ViewHolder(binding.root)

    fun updateBicList(bicList: List<Bic>) {
        this.bicList = bicList
        notifyDataSetChanged()
    }

    interface RoutingCodesItemListener{
        fun onRoutingCodeItemClick(bic: Bic)
    }

}
