package com.example.swensonhe.ui.currencyTask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.swensonhe.R
import com.example.swensonhe.model.CurrencyModel
import com.example.swensonhe.ui.adapter.CurrencyAdapter
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener
import kotlinx.android.synthetic.main.currency_dialog.*
import kotlinx.android.synthetic.main.single_layout_currency.*

class CurrencyDialog(private val data: List<CurrencyModel>) : DialogFragment() {
    private lateinit var migrateCallback: MigrateCallback
    private lateinit var currencyAdapter: CurrencyAdapter
    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.currency_dialog, null, false)
    }

    fun setMigrateCallback(migrateCallback: MigrateCallback) {
        this@CurrencyDialog.migrateCallback = migrateCallback
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }


    private fun setupView() {
        currencyAdapter = CurrencyAdapter(
            requireContext(),
            OnRecyclerItemClickListener {

                migrateCallback.onConfirmClick(data[it])

            })

        rv_currency.apply {
            layoutManager = LinearLayoutManager(context)
            (layoutManager as LinearLayoutManager).orientation = LinearLayoutManager.VERTICAL
            rv_currency.layoutManager = layoutManager
            adapter = currencyAdapter
        }

        currencyAdapter.items = data
    }


    interface MigrateCallback {
        fun onConfirmClick(pos: CurrencyModel)
    }

}
