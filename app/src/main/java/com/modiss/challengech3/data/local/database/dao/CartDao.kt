package com.modiss.challengech3.data.local.database.dao

import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {

    @Query("SELECT * FROM CARTS")
    fun getAllCarts(): Flow<List<CartProductRelation>>

    @Query("SELECT * FROM CARTS WHERE id == :cartId")
    fun getCartById(cartId: Int): Flow<CartProductRelation>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCart(cart: CartEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCarts(cart: List<CartEntity>)

    @Delete
    suspend fun deleteCart(cart: CartEntity): Int

    @Update
    suspend fun updateCart(cart: CartEntity): Int
}