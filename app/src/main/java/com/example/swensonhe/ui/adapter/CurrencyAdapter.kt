package com.example.swensonhe.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.example.swensonhe.R
import com.example.swensonhe.model.CurrencyModel
import com.leodroidcoder.genericadapter.BaseViewHolder
import com.leodroidcoder.genericadapter.GenericRecyclerViewAdapter
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener
import kotlinx.android.synthetic.main.single_layout_currency.view.*


class CurrencyAdapter(context: Context, listener: OnRecyclerItemClickListener) :
    GenericRecyclerViewAdapter<CurrencyModel, OnRecyclerItemClickListener,
            CurrencyAdapter.BenefitsViewHolder>(context, listener) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BenefitsViewHolder {
        return BenefitsViewHolder(inflate(R.layout.single_layout_currency, parent), listener)
    }


    inner class BenefitsViewHolder(
        itemView: View,
        private val listener: OnRecyclerItemClickListener,
    ) :
        BaseViewHolder<CurrencyModel, OnRecyclerItemClickListener>(
            itemView,
            listener
        ),
        View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }

        override fun onBind(item: CurrencyModel) {
            itemView.tv_currencyName.text = item.currency
            itemView.tv_currencyValue.text = item.value.toString()



        }

        override fun onClick(view: View) {
            listener.onItemClick(adapterPosition)
        }
    }
}