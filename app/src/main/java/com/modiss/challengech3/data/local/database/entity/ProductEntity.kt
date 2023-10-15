package com.modiss.challengech3.data.local.database.entity

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "price")
    val price: Double,
    @ColumnInfo(name = "weight_in_kg")
    val weightInKg: Double,
    @ColumnInfo(name = "supplier_name")
    val supplierName: String,
    @ColumnInfo(name = "rating")
    val rating: Double,
    @ColumnInfo(name = "desc")
    val desc: String,
    @ColumnInfo(name = "product_img_url")
    val productImgUrl: String
)


