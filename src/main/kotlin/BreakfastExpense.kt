class BreakfastExpense(amount: Int) : Expense(amount) {
    override fun getName(): String = "Breakfast"
    override fun isMeal() = true
    override fun isOverage() = this.amount > 1000
}
