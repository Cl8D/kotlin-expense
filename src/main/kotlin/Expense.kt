abstract class Expense(
    var amount: Int
) {

    abstract fun getName(): String

    abstract fun isMeal(): Boolean

    abstract fun isOverage(): Boolean
}
