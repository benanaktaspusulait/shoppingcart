package example

import cats.Monoid
import cats.implicits.catsKernelStdGroupForDouble

object ShoppingCart {
  // Define the prices for apples and oranges
  val applePrice = 60.0
  val orangePrice = 25.0

  // Define a data type for the items
  sealed trait Item
  case object Apple extends Item
  case object Orange extends Item

  // Define a function to calculate the total cost with offers applied
  def calculateTotalCostWithOffers(items: List[Item]): Double = {
    // Create a Monoid instance for Double to use Sum
    implicit val monoid: Monoid[Double] = Monoid[Double]

    // Apply buy one, get one free on apples
    val numberOfApples = items.count(_ == Apple)
    val appleDiscount = (numberOfApples / 2) * applePrice
    val appleCost = (numberOfApples * applePrice) - appleDiscount

    // Apply 3 for the price of 2 on oranges
    val numberOfOranges = items.count(_ == Orange)
    val orangeDiscount = (numberOfOranges / 3) * orangePrice
    val orangeCost = (numberOfOranges * orangePrice) - orangeDiscount

    val totalCost = appleCost + orangeCost

    totalCost / 100.0 // Convert cents to pounds
  }

  def main(args: Array[String]): Unit = {
    val items = List(Apple, Apple, Orange, Apple, Orange, Orange, Orange)
    val totalCost = calculateTotalCostWithOffers(items)
    println(s"Total cost with offers: £$totalCost")
  }
}
