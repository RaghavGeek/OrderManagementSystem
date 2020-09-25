package com.example.ordermanagementsystem.service

import com.example.ordermanagementsystem.dao.ProductDao
import com.example.ordermanagementsystem.dao.ProductPriceDao
import com.example.ordermanagementsystem.product.Product
import org.springframework.stereotype.Service
import java.time.LocalDate
@Service
class ProductService(private val proddao:ProductDao,private val pricedao: ProductPriceDao)
{
    companion object {
        fun productAvailability(id: Int,qty:Int,prod: Product): String {
            var result = " "
            result = when {
                prod == null -> {
                    "Product with $id doesn't exist"
                }
                prod.QTY < qty -> {
                    "Product with $id doesn't has sufficient quantity"
                }
                prod.VALID_TO < java.sql.Date.valueOf(LocalDate.now()) && prod.VALID_FROM > java.sql.Date.valueOf(LocalDate.now()) -> {
                    "Product with $id is not valid"
                }
                else -> {
                    "Available"
                }
            }
            return  result.toString()
        }
    }

    fun getProdByQty(id:Int,qty:Int):String{
        var prod = proddao.getProductByID(id)
        var result = productAvailability(id,qty,prod)
        return when (result) {
            "Available" -> prod.toString()
            else -> result.toString()
        }
    }
    fun getProdTotalPrice(id:Int,qty:Int):String{
        var result = " "
        var prod = proddao.getProductByID(id)
        result = when {
            prod == null -> {
                "Product with $id doesn't exist"
            }
            //Checking Product Available Quantity before placing the order
            prod.QTY < qty -> {
                "Product with $id doesn't has sufficient quantity"
            }
            //Checking Product Validity before placing the order
            prod.VALID_TO < java.sql.Date.valueOf(LocalDate.now()) && prod.VALID_FROM > java.sql.Date.valueOf(LocalDate.now())  -> {
                "Product with $id is not valid"
            }
            else -> {
                var totalPrice:Double = 0.0
                totalPrice = qty * pricedao.getProductPriceByProductID(prod).AMOUNT
                totalPrice.toString()
            }
        }
        return result
    }
}
