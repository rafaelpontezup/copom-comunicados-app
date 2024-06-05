package br.com.graphene.copom.comunicados;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CopomController {

    @Autowired
    private CopomService service;

    @GetMapping("/comunicados")
    public List<Comunicado> getComunicados(@RequestParam int count) {
        return service.getUltimosComunicados(count);
    }
}