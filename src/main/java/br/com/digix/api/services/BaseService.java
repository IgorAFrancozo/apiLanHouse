package br.com.digix.api.services;

import br.com.digix.api.dominio.jogador.Jogador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public abstract class BaseService<T> {
    protected List<T> data;

    public abstract void adicionar(T item);

    public abstract void remover(Long id);

    public abstract void atualizar(Long id, T dadosAtualizacao);

}