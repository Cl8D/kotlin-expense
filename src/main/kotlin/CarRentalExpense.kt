class CarRentalExpense(amount: Int) : Expense(Type.CAR_RENTAL, amount) {
    override fun getName(): String = "Car Rental"
    override fun isMeal() = false
    override fun isOverage() = false
}
