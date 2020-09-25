package com.example.ordermanagementsystem.productrepository

import com.example.ordermanagementsystem.product.Order_Details
import com.example.ordermanagementsystem.product.Product
import com.example.ordermanagementsystem.product.Product_Price
import com.example.ordermanagementsystem.product.Transport
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TransportRepository : JpaRepository<Transport, Int>{
    fun findByorder(order: Order_Details): Transport
}
