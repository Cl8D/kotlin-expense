class CarRentalExpense(amount: Int) : Expense(amount) {
    override fun getName(): String = "Car Rental"
    override fun isMeal() = false
    override fun isOverage() = false
}
