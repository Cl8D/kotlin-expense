class Expense(
    var type: Type,
    var amount: Int
) {
    enum class Type {
        DINNER,
        BREAKFAST,
        CAR_RENTAL
    }

    fun getName(): String {
        var name = "TILT"

        when (this.type) {
            Type.DINNER -> name = "Dinner"
            Type.BREAKFAST -> name = "Breakfast"
            Type.CAR_RENTAL -> name = "Car Rental"
        }
        return name
    }

     fun isMeal() = this.type == Type.BREAKFAST || this.type == Type.DINNER

    fun isOverage() = (this.type == Type.DINNER
            && this.amount > 5000
            || this.type === Type.BREAKFAST
            && this.amount > 1000)
}
