package com.example.ordermanagementsystem.dao
import com.example.ordermanagementsystem.product.Product
import com.example.ordermanagementsystem.product.Product_Price
import org.springframework.stereotype.Repository
import com.example.ordermanagementsystem.productrepository.ProdPriceRepository

@Repository
class ProductPriceDao(private val pricerep:ProdPriceRepository){
    fun addProdPrice(price:Product_Price){
        pricerep.save(price)
    }
    fun getProductPriceByProductID(prod:Product):Product_Price{
        return pricerep.findByprod(prod)
    }
}

