package br.com.graphene.copom.comunicados;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "copomClient", url = "https://api.bcb.gov.br/dados/serie/bcdata.sgs.11/dados")
public interface CopomClient {

    @GetMapping("/ultimos/{count}")
    List<Comunicado> getUltimosComunicados(@PathVariable("count") int count);
}

class Comunicado {
    private String data;
    private String valor;

    // Getters e Setters
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
