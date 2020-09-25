package com.example.ordermanagementsystem.productrepository


import com.example.ordermanagementsystem.product.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface ProdRepository : JpaRepository<Product, Int>{
    //Query for updating the stock in hand
    @Modifying
    @Transactional
    @Query("update Product e SET e.QTY= :updatedQty WHERE e.PRODUCT_ID = :id")
    fun updateQty(@Param("id") prod_id:Int, @Param("updatedQty") newQty:Int)
}

