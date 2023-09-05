package example

import example.ShoppingCart._
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class ShoppingCartSpec extends AnyFunSpec with Matchers {
  describe("calculateTotalCostWithOffers") {
    it("should return the correct total cost with offers applied") {
      // 1 Apple (60p each) + 2 Oranges (25p each) = £1.10
      val items1 = List(Apple, Orange, Orange)
      calculateTotalCostWithOffers(items1) shouldEqual 1.10

      // 3 Apples (60p each, one is free) + 4 Oranges (25p each, one is free) = £1.95
      val items2 = List(Apple, Apple, Orange, Apple, Orange, Orange, Orange)
      calculateTotalCostWithOffers(items2) shouldEqual 1.95
    }

    it("should return 0.0 for an empty list") {
      val items = List.empty[Item]
      calculateTotalCostWithOffers(items) shouldEqual 0.0
    }
  }
}
