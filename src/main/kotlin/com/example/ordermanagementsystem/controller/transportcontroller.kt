package com.example.ordermanagementsystem.controller
import com.example.ordermanagementsystem.product.Product
import com.example.ordermanagementsystem.product.Transport
import com.example.ordermanagementsystem.service.TransportService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class TransportController(private val transservice:TransportService) {
    @GetMapping("/transport/{orderid}")
    fun getTransportByOrderId(@PathVariable(value = "orderid") id:Int): ResponseEntity<String>  {
        return ResponseEntity.ok().body(transservice.getTransportByOrderId(id))
    }
    @PostMapping("/placeorder/{quantity}")
    fun createNewOrder(@Valid @RequestBody order: Transport,@PathVariable(value = "quantity") qty:Int): ResponseEntity<String> {
        return ResponseEntity.ok().body(transservice.createNewOrder(order,qty))
    }
}