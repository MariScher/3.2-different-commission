fun main() {
    val cardType = "VkPay"
    val previousAmount = 0
    val amount = 15_000_00

    val limit = amount + previousAmount
    val result = totalFee(cardType, amount, limit,
        calculateFee(cardType, amount, limit)
    )
}

fun totalFee(cardType: String, amount: Int, limit: Int, calculateFee: Int) {

    if (cardType == "Maestro_MC" || cardType == "Visa_Mir" && limit < 600_000_00) {
        println("$calculateFee")
    } else if (cardType == "VkPay" && limit < 40_000_00) {
        println(0)
    } else {
        println("Платеж невозможен, превышен месячный лимит")
    }
}

fun calculateFee(cardType: String, amount: Int, limit: Int): Int {
    return when (cardType) {
        "Maestro_MC" -> {
            if (limit > 75_000_00) (amount * 0.006 + 20).toInt() else 0
        }
        "Visa_Mir" -> {
            if (limit > 35_00) (amount * 0.0075).toInt() else 35_00
        }
        else -> 0
    }
}