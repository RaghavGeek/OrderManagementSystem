package com.example.ordermanagementsystem.controller
import com.example.ordermanagementsystem.product.Product
import com.example.ordermanagementsystem.service.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class ProductController(private val prodservice:ProductService) {
    @GetMapping("/product/{id}/{quantity}")
    fun getProductByQty(@PathVariable(value = "id") id: Int, @PathVariable(value = "quantity") qty: Int): ResponseEntity<String> {
        return ResponseEntity.ok().body(prodservice.getProdByQty(id, qty))
    }
    @GetMapping("/totalprice/{id}/{quantity}")
    fun getProductTotalPrice(@PathVariable(value = "id") id:Int,@PathVariable(value = "quantity") qty:Int): ResponseEntity<String>  {
        return ResponseEntity.ok().body(prodservice.getProdTotalPrice(id,qty))
    }

}

