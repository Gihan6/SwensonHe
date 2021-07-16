package com.example.swensonhe.ui.currencyTask

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.swensonhe.R
import com.example.swensonhe.model.CurrencyModel
import com.example.swensonhe.networkModels.response.GetCurrencyResponse
import com.example.swensonhe.ui.viewModel.MainViewModel
import com.example.swensonhe.util.Status
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val viewModel by inject<MainViewModel>()
    var currencyList = mutableListOf<CurrencyModel>()
    private lateinit var selectCurrency: CurrencyModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListenerForViewModel()
        getCurrencyFromWebService()
        showAllCurrency()
        editBaseCurrency()
    }
    private fun getCurrencyFromWebService(){
        viewModel.getCurrencyTokenFromWebServices()

    }

    private fun showAllCurrency() {
        tv_rateCurrency.setOnClickListener(View.OnClickListener {
            if (!currencyList.isNullOrEmpty())
                showDialog(currencyList)

        })

    }

    private fun editBaseCurrency() {
        et_baseCurrency.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {


            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                try {
                    var result = et_baseCurrency.text.toString().toInt() * selectCurrency.value
                    tv_rateCurrency.text = result.toString()

                } catch (e: Exception) {

                }


            }
        })

    }


    private fun showDialog(data: List<CurrencyModel>) {
        val ft = supportFragmentManager.beginTransaction()
        val newFragment = CurrencyDialog(data)
        newFragment.setMigrateCallback(object : CurrencyDialog.MigrateCallback {
            override fun onConfirmClick(currency: CurrencyModel) {

                selectCurrency = currency
                tv_currencyName.text = currency.currency
                tv_rateCurrency.text = currency.value.toString()
                et_baseCurrency.setText("1")
                newFragment.dismiss()

            }
        })
        newFragment.show(ft, "dialog")
    }


    private fun initListenerForViewModel() {
        viewModel.getCurrency().observe(this, androidx.lifecycle.Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        pb_loading.visibility = View.GONE
                        if (it.data!!.success) {
                            tv_baseCurrency.text = it.data.base
                            tv_rateCurrency.text = getString(R.string.enter_here)
                            createList(it.data.rates)
                        }
                    }
                    Status.ERROR -> {
                        pb_loading.visibility = View.GONE

                    }
                    Status.LOADING -> {
                        pb_loading.visibility = View.VISIBLE

                    }
                }
            }

        })
    }

    private fun createList(data: GetCurrencyResponse.Rates) {
        currencyList.add(CurrencyModel("AED", data.aED))
        currencyList.add(CurrencyModel("AFN", data.aFN))
        currencyList.add(CurrencyModel("ALL", data.aLL))
        currencyList.add(CurrencyModel("AMD", data.aMD))
        currencyList.add(CurrencyModel("ANG", data.aNG))
        currencyList.add(CurrencyModel("AOA", data.aOA))
        currencyList.add(CurrencyModel("ARS", data.aRS))
        currencyList.add(CurrencyModel("AUD", data.aUD))
        currencyList.add(CurrencyModel("AWG", data.aWG))
        currencyList.add(CurrencyModel("AZN", data.aZN))
        currencyList.add(CurrencyModel("BAM", data.bAM))
        currencyList.add(CurrencyModel("BBD", data.bBD))


    }
}
