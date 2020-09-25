package com.example.ordermanagementsystem.controller
import com.example.ordermanagementsystem.service.OrderService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class OrderController(private val ordservice:OrderService) {
    @GetMapping("/order/{id}")
    fun getOrderStatusByOrderID(@PathVariable(value = "id") id:Int): ResponseEntity<String>  {
        return ResponseEntity.ok().body(ordservice.getOrderByID(id))
    }
}
