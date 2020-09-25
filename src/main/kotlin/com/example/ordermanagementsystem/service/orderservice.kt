package com.example.ordermanagementsystem.service

import com.example.ordermanagementsystem.dao.*
import com.example.ordermanagementsystem.product.Order_Details
import com.example.ordermanagementsystem.product.Transport
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.time.LocalDate
@Service
class OrderService(private val orddao: OrderDao,private val proddao: ProductDao,private val pricedao:ProductPriceDao,private val transdao:TransportDao)
{
    //Fetching Order Details By ID
    fun getOrderByID(id:Int):String{
        var result = " "
        var order = orddao.getOrderByOrderId(id)
        result = when {
            order == null ->{
                "Order with $id not found"
            }
            else ->{
                order.toString()
            }
        }
        return result
    }
}
