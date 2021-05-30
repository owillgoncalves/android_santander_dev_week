package com.williammago.santanderdevweek.data.local

import com.williammago.santanderdevweek.data.Account
import com.williammago.santanderdevweek.data.Card
import com.williammago.santanderdevweek.data.Client

class FakeData {
    fun getLocalData() : Account {
        val client = Client("William")
        val card = Card("1234123412341234")
        return Account(
            "1234567-8",
            "1234",
            1234.56f,
            1000.00f,
            client,
            card,
        )
    }
}