package com.modiss.challengech3.presentation.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CartViewModel(private val repo: CartRepository) : ViewModel() {

    val cartList = repo.getUserCartData().asLiveData(Dispatchers.IO)

    fun decreaseCart(item: Cart) {
        viewModelScope.launch {repo.decreaseCart(item).collect()}
    }

}