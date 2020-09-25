package com.example.ordermanagementsystem.productrepository
import com.example.ordermanagementsystem.product.Product
import com.example.ordermanagementsystem.product.Product_Price
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface ProdPriceRepository : JpaRepository<Product_Price, Int>{
    fun findByprod(prod: Product): Product_Price
}