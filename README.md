# movilepay-android-interview

## Descrição:

O teste consiste em desenvolver um app nativo para Android, onde será implementado uma tela principal com uma lista de widgets, e cada um pode ter ou não uma ação.

Desejável:

- Modularização;
- Testes unitários e de fluxo;

### Home: lista de widgets:

- O conteúdo a ser exibido na tela principal é retornado de uma request na seguinte url: [https://mpay-banking-app-mock-server.herokuapp.com/android/interview/home](https://mpay-banking-app-mock-server.herokuapp.com/android/interview/home);
- O retorno é dinâmico, é possível que algum widget não seja retornado, assim como podem parecer outros widgets não mapeados;
- Os widgets com action, deve conter cliques que executam alguma ação, no nosso exemplo vão abrir duas telas novas: CARD_SCREEN, STATEMENT_SCREEN;
- O layout em si não é importante, apenas as boas práticas relacionadas;

### Cartão: detalhes do cartão:

- O conteúdo a ser exibido na tela de cartão é retornado de uma request na seguinte url: [https://mpay-banking-app-mock-server.herokuapp.com/android/interview/card/123](https://mpay-banking-app-mock-server.herokuapp.com/android/interview/card/123);
- O retorno sempre terá os mesmos campos;
- O layout em si não é importante, apenas as boas práticas relacionadas;
- Tratamento de erro caso o ID não seja 123;

### Extrato: detalhes da conta:

- O conteúdo a ser exibido na tela principal é retornado de uma request na seguinte url: [https://mpay-banking-app-mock-server.herokuapp.com/android/interview/statement/123](https://mpay-banking-app-mock-server.herokuapp.com/android/interview/statement/123);
- O retorno sempre terá os mesmo campos;
- O layout em si não é importante, apenas as boas práticas relacionadas;
- Tratamento de erro caso o ID não seja 123;