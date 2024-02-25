class BreakfastExpense(amount: Int) : Expense(Type.BREAKFAST, amount) {
    override fun getName(): String {
        var name = "TILT"

        when (this.type) {
            Type.DINNER -> name = "Dinner"
            Type.BREAKFAST -> name = "Breakfast"
            Type.CAR_RENTAL -> name = "Car Rental"
        }
        return name
    }

    override fun isMeal() = this.type == Type.BREAKFAST || this.type == Type.DINNER
    override fun isOverage() = (this.type == Type.DINNER
            && this.amount > 5000
            || this.type === Type.BREAKFAST
            && this.amount > 1000)

}
