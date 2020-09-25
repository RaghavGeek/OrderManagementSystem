package com.example.ordermanagementsystem.product
import org.springframework.beans.factory.annotation.Autowired
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "order_details")
data class Order_Details (
        @Column(name = "ORDER_ID")
        @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
        var ORDERID: Int = 0,
        @NotNull
        var PRODUCT_ID: Int = 0,
        @NotNull
        var TOTAL_PRICE: Double = 0.0
)