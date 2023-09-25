package br.com.digix.api.services;

import br.com.digix.api.dominio.partida.Partida;

import java.util.ArrayList;
import java.util.List;

public class PartidaService extends BaseService<Partida> {
    @Override
    public void adicionar(Partida partida) {
        // TODO para adicionar uma partida
    }

    @Override
    public void remover(Long jogadorId) {

    }

    @Override
    public void atualizar(Long id, Partida dadosAtualizacao) {

    }

    public void iniciarPartida(Partida partida) {
        // TODO lógica para iniciar uma partida
    }

    public void finalizarPartida(Partida partida) {
        // TODO lógica para finalizar uma partida
    }
}
