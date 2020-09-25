package com.example.ordermanagementsystem.service
import com.example.ordermanagementsystem.dao.OrderDao
import com.example.ordermanagementsystem.dao.ProductDao
import com.example.ordermanagementsystem.dao.TransportDao
import com.example.ordermanagementsystem.dao.ProductPriceDao
import com.example.ordermanagementsystem.product.Transport
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class TransportService(private val transdao:TransportDao, private val proddao: ProductDao, private val pricedao:ProductPriceDao,private val orderdao: OrderDao)
{
    fun getTransportByOrderId(id: Int):String {
        var order = orderdao.getOrderByOrderId(id)
        return when {
            order != null ->  transdao.getTransportStatusByOrderID(order).toString()
            else ->  "Order ID doesn't exist"
        }
    }
    fun createNewOrder(order: Transport,qty:Int):String {
        var result = " "
        var prodID = order.order.PRODUCT_ID
        var prod = proddao.getProductByID(prodID)
        result = ProductService.productAvailability(prodID,qty,prod)
        return when(result) {
            "Available" -> {
                var totalPrice:Double = 0.0
                order.order.TOTAL_PRICE = qty * pricedao.getProductPriceByProductID(prod).AMOUNT
                transdao.createNewOrder(order)
                //Updating Stock in Hand after placing the order
                proddao.updateQuantity(prodID,prod.QTY - qty)
                order.toString()
            }
            else-> result.toString()
        }

    }
}