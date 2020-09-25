package com.example.ordermanagementsystem.controller
import com.example.ordermanagementsystem.product.Product_Price
import com.example.ordermanagementsystem.service.PriceService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class PriceController(private val prodpriceservice:PriceService) {
    @PostMapping("/product")
    fun createNewProduct(@Valid @RequestBody prod: Product_Price):ResponseEntity<String> {
        prodpriceservice.addProductPrice(prod)
        return ResponseEntity.ok().body("Product Added Successfully")
    }
}