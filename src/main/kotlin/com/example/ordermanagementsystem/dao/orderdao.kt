package com.example.ordermanagementsystem.dao
import com.example.ordermanagementsystem.product.Order_Details
import org.springframework.stereotype.Repository
import com.example.ordermanagementsystem.productrepository.OrderRepository
import org.springframework.data.repository.findByIdOrNull

@Repository
class OrderDao(private val orderrep:OrderRepository){
    fun getOrderByOrderId(id:Int):Order_Details?{
       return orderrep.findByIdOrNull(id)
    }
}