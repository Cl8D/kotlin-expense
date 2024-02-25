abstract class Expense(
    var amount: Int
) {
    enum class Type {
        DINNER,
        BREAKFAST,
        CAR_RENTAL
    }

    abstract fun getName(): String

    abstract fun isMeal(): Boolean

    abstract fun isOverage(): Boolean
}
