class ExpenseReport {
    private val expenses: MutableList<Expense> = ArrayList()
    private val date: String
        get() = "9/12/2002"
    private var total = 0
    private var mealExpenses = 0
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
        val name = getName(expense)

        printer.print(
            String.format(
                "%s\t%s\t$%.02f\n",
                if (expense.type == Expense.Type.DINNER
                    && expense.amount > 5000
                    || expense.type === Expense.Type.BREAKFAST
                    && expense.amount > 1000
                ) "X" else " ",
                name, expense.amount / 100.0
            )
        )
    }

    private fun getName(expense: Expense): String {
        var name = "TILT"

        when (expense.type) {
            Expense.Type.DINNER -> name = "Dinner"
            Expense.Type.BREAKFAST -> name = "Breakfast"
            Expense.Type.CAR_RENTAL -> name = "Car Rental"
        }
        return name
    }

    private fun calculateExpenses() {
        for (expense in expenses) {
            addTotal(expense)
        }
    }

    private fun addTotal(expense: Expense) {
        if (isMeal(expense)) {
            mealExpenses += expense.amount
        }
        total += expense.amount
    }

    private fun isMeal(expense: Expense) = expense.type == Expense.Type.BREAKFAST || expense.type == Expense.Type.DINNER

    private fun printTotal() {
        printer.print(String.format("\nMeal expenses $%.02f", mealExpenses / 100.0))
        printer.print(String.format("\nTotal $%.02f", total / 100.0))
    }

    private fun printHeader() {
        printer.print("Expenses " + date + "\n")
    }

    fun addExpense(expense: Expense) {
        expenses.add(expense)
    }
}
