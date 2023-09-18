package com.veniamin.onlinewallet.service;

import com.veniamin.onlinewallet.config.EpayParams;
import com.veniamin.onlinewallet.model.GetAuthModel;
import com.veniamin.onlinewallet.model.InvoiceModel;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import okhttp3.Call;
import okhttp3.Response;
import okhttp3.Callback;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
@Service
@RequiredArgsConstructor
public class PaymentService {

    private final EpayClient client;

    public void getAuthToken() {

//        InvoiceModel invoice = new InvoiceModel(
//                "Venya",
//                "epay@halykbank.kz",
//                "7715353963",
//                BigDecimal.valueOf(75.0),
//                55d,
//                "https://test-epay.homebank.kz",
//                "https://webhookurl.com/",
//                "a comment"
//        );

        var getAuthModel = new GetAuthModel(
                EpayParams.grant_type,
                EpayParams.scope,
                EpayParams.client_id,
                EpayParams.client_secret,
                "",
                "10900",
                EpayParams.currency,
                EpayParams.terminal,
                EpayParams.postLink,
                EpayParams.failurePostLink
        );

        //handle response after you get it as a call back
        client.getAuthToken(getAuthModel, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                //in case of failure
                System.out.println("failure " + e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                //in case of success
                System.out.println("Success " + response);
            }
        });
    }
}