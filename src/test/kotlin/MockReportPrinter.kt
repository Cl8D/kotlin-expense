class MockReportPrinter : ReportPrinter {
    private var printedText = ""

    override fun print(text: String?) {
        printedText += text

    }

    fun getText(): String {
        return printedText
    }
}
