package app.filipebezerra.demo.android.movpaybank.test.data

import app.filipebezerra.demo.android.movpaybank.data.api.*
import app.filipebezerra.demo.android.movpaybank.domain.model.*

object TestData {

    val bankWidgetsDto = listOf(
        BankWidgetDto(
            identifier = "HOME_HEADER_WIDGET",
            content = BankWidgetContentDto(
                title = "Olá Fulano!"
            )
        ),
        BankWidgetDto(
            identifier = "HOME_CARD_WIDGET",
            content = BankWidgetContentDto(
                title = "Meu cartão",
                cardNumber = "•••• •••• •••• 8765",
                button = BankWidgetButtonDto(
                    text = "Ver detalhes",
                    action = BankWidgetButtonActionDto(
                        identifier = "CARD_SCREEN",
                        content = BankWidgetButtonActionContentDto(
                            cardId = "123"
                        )
                    )
                )
            ),
        ),
        BankWidgetDto(
            identifier = "HOME_STATEMENT_WIDGET",
            content = BankWidgetContentDto(
                title = "Meu saldo",
                balance = BankTransactionDto(
                    label = "Saldo disponível",
                    value = "R$ 50.000,00"
                ),
                button = BankWidgetButtonDto(
                    text = "Ver extrato",
                    action = BankWidgetButtonActionDto(
                        identifier = "STATEMENT_SCREEN",
                        content = BankWidgetButtonActionContentDto(
                            accountId = "123"
                        )
                    )
                )
            ),
        )
    )

    val bankWidgets = listOf(
        BankWidget(
            identifier = "HOME_HEADER_WIDGET",
            content = BankWidgetContent(
                title = "Olá Fulano!"
            )
        ),
        BankWidget(
            identifier = "HOME_CARD_WIDGET",
            content = BankWidgetContent(
                title = "Meu cartão",
                cardNumber = "•••• •••• •••• 8765",
                button = BankWidgetButton(
                    text = "Ver detalhes",
                    action = BankWidgetButtonAction(
                        identifier = "CARD_SCREEN",
                        content = BankWidgetButtonActionContent(
                            cardId = "123"
                        )
                    )
                )
            ),
        ),
        BankWidget(
            identifier = "HOME_STATEMENT_WIDGET",
            content = BankWidgetContent(
                title = "Meu saldo",
                balance = BankTransaction(
                    label = "Saldo disponível",
                    value = "R$ 50.000,00"
                ),
                button = BankWidgetButton(
                    text = "Ver extrato",
                    action = BankWidgetButtonAction(
                        identifier = "STATEMENT_SCREEN",
                        content = BankWidgetButtonActionContent(
                            accountId = "123"
                        )
                    )
                )
            ),
        )
    )

    val bankCardDto = BankCardDto(
        cardNumber = "•••• •••• •••• 8765",
        cardName = "Teste Fulano Ciclano",
        expirationDate = "09/25",
        availableLimit = "R$ 3.000,00",
        totalLimit = "R$ 5.000,00"
    )
    val bankCard = BankCard(
        cardNumber = "•••• •••• •••• 8765",
        cardName = "Teste Fulano Ciclano",
        expirationDate = "09/25",
        availableLimit = "R$ 3.000,00",
        totalLimit = "R$ 5.000,00"
    )
    const val validCardId = "123"
    const val invalidCardId = "invalid"

    val bankStatement = BankStatement(
        balance = BankTransaction(
            label = "Saldo disponível",
            value = "R$ 50.000,00"
        ),
        transactions = listOf(
            BankTransaction(
                label = "Transferência enviada",
                value = "- R$ 500,00",
                description = "Teste fulano ciclano"
            ),
            BankTransaction(
                label = "Pagamento realizado",
                value = "- R$ 645,00",
                description = "Teste fulano ciclano"
            ),
            BankTransaction(
                label = "Transferência recebida",
                value = "+ R$ 2000,00",
                description = "Movile Pay"
            )
        )
    )
    val bankStatementDto = BankStatementDto(
        balance = BankTransactionDto(
            label = "Saldo disponível",
            value = "R$ 50.000,00"
        ),
        transactions = listOf(
            BankTransactionDto(
                label = "Transferência enviada",
                value = "- R$ 500,00",
                description = "Teste fulano ciclano"
            ),
            BankTransactionDto(
                label = "Pagamento realizado",
                value = "- R$ 645,00",
                description = "Teste fulano ciclano"
            ),
            BankTransactionDto(
                label = "Transferência recebida",
                value = "+ R$ 2000,00",
                description = "Movile Pay"
            )
        )
    )
    const val validAccountId = "123"
    const val invalidAccountId = "invalid"
}