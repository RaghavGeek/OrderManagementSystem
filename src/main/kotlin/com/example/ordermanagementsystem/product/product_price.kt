package com.example.ordermanagementsystem.product
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
@Table(name="product_price")
data class Product_Price (
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var ID:Int = 0,
        //Using One to One Association by considering a one price for one product
        @OneToOne(cascade= [CascadeType.ALL])
        @JoinColumn(name = "PRODUCT_ID")
        var prod:Product,
        @NotNull
        var AMOUNT: Double = 0.0,
        @get: NotBlank
        var CURRENCY: String = "",
        @NotNull
        var VALID_FROM: Date = Date(),
        @NotNull
        var VALID_TO: Date = Date()
        )