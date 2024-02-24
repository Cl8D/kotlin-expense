class ExpenseReport {
    private val expenses: MutableList<Expense> = ArrayList()
    private val date: String
        get() = "9/12/2002"

    fun printReport(printer: ReportPrinter) {
        printHeader(printer)
        var total = 0
        var mealExpenses = 0

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
        printTotal(printer, mealExpenses, total)
    }

    private fun printTotal(printer: ReportPrinter, mealExpenses: Int, total: Int) {
        printer.print(String.format("\nMeal expenses $%.02f", mealExpenses / 100.0))
        printer.print(String.format("\nTotal $%.02f", total / 100.0))
    }

    private fun printHeader(printer: ReportPrinter) {
        printer.print("Expenses " + date + "\n")
    }

    fun addExpense(expense: Expense) {
        expenses.add(expense)
    }
}