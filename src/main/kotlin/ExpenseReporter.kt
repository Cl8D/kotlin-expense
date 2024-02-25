class ExpenseReporter : ExpenseReport() {
    private val date: String
        get() = "9/12/2002"
    private lateinit var printer: ReportPrinter

    fun printReport(printer: ReportPrinter) {
        this.printer = printer
        calculateExpenses()
        printExpensesAndTotal()
    }

    private fun printExpensesAndTotal() {
        printHeader()
        printExpenses()
        printTotal()
    }

    private fun printExpenses() {
        for (expense in expenses) {
            printExpense(expense)
        }
    }

    private fun printExpense(expense: Expense) {
        printer.print(
            String.format(
                "%s\t%s\t$%.02f\n",
                if (expense.isOverage()) "X" else " ",
                expense.getName(), getRate(expense.amount)
            )
        )
    }

    private fun printTotal() {
        printer.print(String.format("\nMeal expenses $%.02f", getRate(mealExpenses)))
        printer.print(String.format("\nTotal $%.02f", getRate(total)))
    }

    private fun getRate(amount: Int) = amount / 100.0

    private fun printHeader() {
        printer.print("Expenses " + date + "\n")
    }
}
