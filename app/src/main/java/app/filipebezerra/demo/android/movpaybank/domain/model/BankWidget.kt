package app.filipebezerra.demo.android.movpaybank.domain.model

data class BankWidget(
    val identifier: String,
    val content: BankWidgetContent
)

data class BankWidgetContent(
    val title: String,
    val cardNumber: String? = null,
    val balance: BankTransaction? = null,
    val button: BankWidgetButton? = null
)

data class BankWidgetButton(
    val text: String,
    val action: BankWidgetButtonAction,
)

data class BankWidgetButtonAction(
    val identifier: String,
    val content: BankWidgetButtonActionContent? = null,
)

data class BankWidgetButtonActionContent(
    val cardId: String? = null,
    val accountId: String? = null,
)