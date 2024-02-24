class Expense(
    var type: Type,
    var amount: Int
) {
    enum class Type {
        DINNER,
        BREAKFAST,
        CAR_RENTAL
    }
}
