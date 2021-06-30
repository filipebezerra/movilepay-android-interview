package app.filipebezerra.demo.android.movpaybank.test.mocks

import app.filipebezerra.demo.android.movpaybank.data.api.*
import app.filipebezerra.demo.android.movpaybank.domain.model.*

object MockData {

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
                balance = BankValueDto(
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
                balance = BankValue(
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
}