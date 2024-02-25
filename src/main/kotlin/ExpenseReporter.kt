class ExpenseReporter {
    private val date: String
        get() = "9/12/2002"
    private lateinit var printer: ReportPrinter
    private val expenseReport: ExpenseReport = ExpenseReport()

    fun printReport(printer: ReportPrinter) {
        this.printer = printer
        expenseReport.calculateExpenses()
        printExpensesAndTotal()
    }

    private fun printExpensesAndTotal() {
        printHeader()
        printExpenses()
        printTotal()
    }

    private fun printExpenses() {
        for (expense in expenseReport.expenses) {
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
        printer.print(String.format("\nMeal expenses $%.02f", getRate(expenseReport.mealExpenses)))
        printer.print(String.format("\nTotal $%.02f", getRate(expenseReport.total)))
    }

    private fun getRate(amount: Int) = amount / 100.0

    private fun printHeader() {
        printer.print("Expenses " + date + "\n")
    }

    fun addExpense(expense: Expense) {
        expenseReport.addExpense(expense)
    }
}
