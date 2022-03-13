import org.junit.Test

import org.junit.Assert.*

class DifferentCommissionKtTest {

    @Test
    fun total_Fee_VkPay() {
        // arrange
        val cardType = CardType.VkPay
        val amount = 15_000_00
        val previousAmount = 0

        // act
        val result = totalFee(
            cardType = cardType,
            limit = amount + previousAmount,
            amount = amount
        )

        // assert
        assertEquals(println(0), result)
    }

    @Test
    fun total_Fee_Visa() {
        // arrange
        val cardType = CardType.Visa
        val amount = 150_000_00
        val previousAmount = 0

        // act
        val result = totalFee(
            cardType = cardType,
            limit = amount + previousAmount,
            amount = amount
        )

        // assert
        assertEquals(println(1125_00), result)
    }

    @Test
    fun total_Fee_Maestro() {
        // arrange
        val cardType = CardType.Maestro
        val amount = 150_000_00
        val previousAmount = 120_000_00

        // act
        val result = totalFee(
            cardType = cardType,
            limit = amount + previousAmount,
            amount = amount
        )

        // assert
        assertEquals(println(920_00), result)
    }

    @Test
    fun total_Fee_Mir() {
        // arrange
        val cardType = CardType.Mir
        val amount = 150_000_00
        val previousAmount = 120_000_00

        // act
        val result = totalFee(
            cardType = cardType,
            limit = amount + previousAmount,
            amount = amount
        )

        // assert
        assertEquals(println(1125_00), result)
    }

    @Test
    fun total_Fee_Else() {
        // arrange
        val cardType = CardType.MC
        val amount = 150_000_00
        val previousAmount = 520_000_00

        // act
        val result = totalFee(
            cardType = cardType,
            limit = amount + previousAmount,
            amount = amount
        )

        // assert
        assertEquals(println("Платеж невозможен, превышен месячный лимит"), result)
    }

    @Test
    fun calculate_Fee_VkPay() {
        // arrange
        val cardType = CardType.VkPay
        val amount = 15_000_00
        val previousAmount = 0

        // act
        val result = calculateFee(
            cardType = cardType,
            limit = amount + previousAmount,
            amount = amount
        )

        // assert
        assertEquals(0, result)
    }

    @Test
    fun calculate_Fee_MC() {
        // arrange
        val cardType = CardType.MC
        val amount = 150_000_00
        val previousAmount = 0

        // act
        val result = calculateFee(
            cardType = cardType,
            limit = amount + previousAmount,
            amount = amount
        )

        // assert
        assertEquals(920_00, result)
    }

    @Test
    fun calculate_Fee_Mir() {
        // arrange
        val cardType = CardType.Mir
        val amount = 150_000_00
        val previousAmount = 0

        // act
        val result = calculateFee(
            cardType = cardType,
            limit = amount + previousAmount,
            amount = amount
        )

        // assert
        assertEquals(112_00, result)
    }
}