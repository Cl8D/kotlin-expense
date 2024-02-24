interface ReportPrinter {
    fun print(text: String?)
}

class ExpenseReport {
    private val expenses: MutableList<Expense> = ArrayList()
    private val date: String
        get() = "9/12/2002"

    fun printReport(printer: ReportPrinter) {
        var total = 0
        var mealExpenses = 0
        printer.print("Expenses " + date + "\n")

        for (expense in expenses) {
            if (expense.type == Expense.Type.BREAKFAST || expense.type == Expense.Type.DINNER) {
                mealExpenses += expense.amount
            }
            var name = "TILT"

            when (expense.type) {
                Expense.Type.DINNER -> name = "Dinner"
                Expense.Type.BREAKFAST -> name = "Breakfast"
                Expense.Type.CAR_RENTAL -> name = "Car Rental"
            }

            printer.print(
                String.format(
                    "%s\t%s\t$%.02f\n",
                    if (expense.type == Expense.Type.DINNER
                        && expense.amount > 5000
                        || expense.type === Expense.Type.BREAKFAST
                        && expense.amount > 1000) "X" else " ",
                    name, expense.amount / 100.0
                )
            )
            total += expense.amount
        }
        printer.print(String.format("\nMeal expenses $%.02f", mealExpenses / 100.0))
        printer.print(String.format("\nTotal $%.02f", total / 100.0))
    }

    fun addExpense(expense: Expense) {
        expenses.add(expense)
    }
}
