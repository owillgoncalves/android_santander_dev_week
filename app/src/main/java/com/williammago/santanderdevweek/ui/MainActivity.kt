package com.williammago.santanderdevweek.ui

import android.content.Context
import com.williammago.santanderdevweek.data.Account
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.williammago.santanderdevweek.R

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.tb_app))

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        searchClientAccount()
    }

    private fun searchClientAccount() {
        mainViewModel.searchClientAccount().observe(this, { result ->
            bindOnView(result)
        })
    }

    private fun getStringId(ctx: Context, name: String) : Int {
        return ctx.resources.getIdentifier(name,"string", ctx.packageName)
    }

    private fun setText(id : String, value: String) : CharSequence {
        return getString(getStringId(applicationContext, id), value)
    }

    private fun bindOnView(account: Account) {
        val balanceLimitSumString = account.balance.plus(account.limit).toString()

        findViewById<TextView>(R.id.tv_username).text = setText("tv_username", account.client.name)
        findViewById<TextView>(R.id.tv_agency).text = setText("tv_agency", account.agency)
        findViewById<TextView>(R.id.tv_account).text = setText("tv_account", account.account)
        findViewById<TextView>(R.id.tv_balance).text = setText("tv_balance", account.balance.toString())
        findViewById<TextView>(R.id.tv_balance_limit_value).text = setText("tv_balance_limit_value", balanceLimitSumString)
        findViewById<TextView>(R.id.tv_cards_data).text = account.card.cardNumber.subSequence(12..15)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_1 -> {
                Log.d("click", "Clique no item 1")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}