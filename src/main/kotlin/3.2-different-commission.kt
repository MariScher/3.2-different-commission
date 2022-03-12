enum class CardType {
    Maestro, MC, Visa, Mir, VkPay
}

fun main() {
    val previousAmount = 0
    val amount = 15_000_00

    val limit = amount + previousAmount
    totalFee(cardType = CardType.VkPay, limit, amount)
}

fun totalFee(cardType: CardType, limit: Int, amount: Int) =
    if (cardType == CardType.Maestro || cardType == CardType.MC ||
        cardType == CardType.Visa || cardType == CardType.Mir && limit < 600_000_00
    ) {
        val totalFee = calculateFee(cardType, amount, limit)
        println("Ваша комиссия составит: $totalFee")
    } else if (cardType == CardType.VkPay && limit < 40_000_00) {
        println(0)
    } else {
        println("Платеж невозможен, превышен месячный лимит")
    }

fun calculateFee(cardType: CardType, amount: Int, limit: Int) = when (cardType) {
    CardType.Maestro, CardType.MC -> {
        if (limit > 75_000_00) (amount * 0.006 + 20).toInt() else 0
    }
    CardType.Visa, CardType.Mir -> {
        if (limit > 35_00) (amount * 0.0075).toInt() else 35_00
    }
    CardType.VkPay -> 0
}