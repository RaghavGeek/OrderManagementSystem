package com.example.ordermanagementsystem.service

import com.example.ordermanagementsystem.dao.ProductPriceDao
import com.example.ordermanagementsystem.product.Product_Price
import org.springframework.stereotype.Service
@Service
class PriceService(private val pricedao:ProductPriceDao)
{
    fun addProductPrice(prod: Product_Price) {
        pricedao.addProdPrice(prod)
    }
}