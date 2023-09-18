export const epayParams = {
    invoiceId: "0010000098564546",
    invoiceIdAlt: "8564546",
    backLink: "http://localhost:8081/#/Deposit",//"http://localhost:8080/success-transaction",
    failureBackLink: "http://localhost:8081/#/Deposit",//"http://localhost:8080/failure-transaction",
    postLink: "http://localhost:8081/#/Deposit",
    failurePostLink: "http://localhost:8081/#/Deposit",
    language: "rus",
    description: "Оплата в интернет магазине типо",
    accountId: "testuser1",
    terminal: "67e34d63-102f-4bd1-898e-370781d0074d",
    data: "{\"statement\":{\"name\":\"Arman      Ali\",\"invoiceID\":\"001000009\"}}",
    currency: "KZT",
    phone: "77777777777",
    email: "epay@halykbank.kz",

    grant_type: "client_credentials",
    scope: "webapi usermanagement email_send verification statement statistics payment",
    client_id: "test",
    client_secret: "yF587AV9Ms94qN2QShFzVR3vFnWkhjbAK3sG",

    AUTH_TEST_URL: "https://testoauth.homebank.kz/epay2/oauth2/token",
    URL_TEST: "https://test-epay.homebank.kz/payform/payment-api.js",
}
