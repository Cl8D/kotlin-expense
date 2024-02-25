class DinnerExpense(amount: Int) : Expense(Type.DINNER, amount) {
    override fun getName(): String = "Dinner"
    override fun isMeal() = true
    override fun isOverage() = this.amount > 5000
}
