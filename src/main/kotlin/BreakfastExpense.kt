class BreakfastExpense(amount: Int) : Expense(Type.BREAKFAST, amount) {
    override fun getName(): String = "Breakfast"
    override fun isMeal() = true
    override fun isOverage() = this.amount > 1000
}
