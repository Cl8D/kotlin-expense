import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class ExpenseReportTest : StringSpec({
    lateinit var report: ExpenseReport
    lateinit var printer: MockReportPrinter

    beforeTest {
        report = ExpenseReport()
        printer = MockReportPrinter()
    }

    "printEmpty" {
        report.printReport(printer)

        printer.getText() shouldBe """
            Expenses 9/12/2002

            Meal expenses $0.00
            Total $0.00
        """.trimIndent()
    }

    "printOneDinner" {
        report.addExpense(Expense(Expense.Type.DINNER, 1678))
        report.printReport(printer)

        printer.getText() shouldBe """
            Expenses 9/12/2002
             	Dinner	$16.78

            Meal expenses $16.78
            Total $16.78
        """.trimIndent()
    }

    "twoMeals" {
        report.addExpense(Expense(Expense.Type.DINNER, 1000))
        report.addExpense(Expense(Expense.Type.BREAKFAST, 500))
        report.printReport(printer)

        printer.getText() shouldBe """
            Expenses 9/12/2002
             	Dinner	$10.00
             	Breakfast	$5.00

            Meal expenses $15.00
            Total $15.00
        """.trimIndent()
    }

    "twoMealsAndCarRental" {
        report.addExpense(Expense(Expense.Type.DINNER, 1000))
        report.addExpense(Expense(Expense.Type.BREAKFAST, 500))
        report.addExpense(Expense(Expense.Type.CAR_RENTAL, 50000))
        report.printReport(printer)

        printer.getText() shouldBe """
            Expenses 9/12/2002
             	Dinner	$10.00
             	Breakfast	$5.00
             	Car Rental	$500.00

            Meal expenses $15.00
            Total $515.00
        """.trimIndent()
    }

    "overages" {
        report.addExpense(Expense(Expense.Type.BREAKFAST, 1000))
        report.addExpense(Expense(Expense.Type.BREAKFAST, 1001))
        report.addExpense(Expense(Expense.Type.DINNER, 5000))
        report.addExpense(Expense(Expense.Type.DINNER, 5001))
        report.printReport(printer)

        printer.getText() shouldBe """
            Expenses 9/12/2002
             	Breakfast	$10.00
            X	Breakfast	$10.01
             	Dinner	$50.00
            X	Dinner	$50.01

            Meal expenses $120.02
            Total $120.02
        """.trimIndent()
    }
})
