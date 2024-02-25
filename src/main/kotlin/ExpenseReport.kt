open class ExpenseReport {
    protected val expenses: MutableList<Expense> = ArrayList()
    protected var total = 0
    protected var mealExpenses = 0
    protected fun calculateExpenses() {
        for (expense in expenses) {
            addTotal(expense)
        }
    }

    private fun addTotal(expense: Expense) {
        if (expense.isMeal()) {
            mealExpenses += expense.amount
        }
        total += expense.amount
    }

    fun addExpense(expense: Expense) {
        expenses.add(expense)
    }
}
