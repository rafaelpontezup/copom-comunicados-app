package br.com.graphene.novoboletoapp0504.boletos;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "banklyClient", url = "https://api-mtls.sandbox.bankly.com.br")
public interface BanklyClient {

    @PostMapping("/bankslip")
    BankSlipResponse createBankSlip(
        @RequestHeader("Authorization") String authorization,
        @RequestHeader("Api-Version") String apiVersion,
        @RequestBody BankSlipRequest bankSlipRequest
    );
}