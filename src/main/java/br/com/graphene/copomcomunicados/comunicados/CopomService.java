package br.com.graphene.copomcomunicados.comunicados;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CopomService {

    @Autowired
    private CopomClient copomClient;

    public List<Comunicado> getUltimosComunicados(int count) {
        return copomClient.getUltimosComunicados(count);
    }
}