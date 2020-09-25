package com.example.ordermanagementsystem.dao
import com.example.ordermanagementsystem.product.Product
import org.springframework.stereotype.Repository
import com.example.ordermanagementsystem.productrepository.ProdRepository

@Repository
class ProductDao(private val prodrep:ProdRepository){
    fun getProductByID(id:Int):Product{
        return prodrep.findById(id).orElse(null)
    }
    fun updateQuantity(id: Int, updatedQty: Int) {
        prodrep.updateQty(id,updatedQty)
    }
}


