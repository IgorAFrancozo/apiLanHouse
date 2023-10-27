package br.com.digix.api.dominio.categoria;

import br.com.digix.api.dominio.ValidacaoException;
import br.com.digix.api.dominio.util.NormalizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private NormalizacaoService normalizacaoService;

    public Categoria salvarCategoria(Categoria categoria) {
        String nomeNormalizado = normalizacaoService.normalizarString(categoria.getNome());
        Categoria categoriaExistente = categoriaRepository.findByNome(nomeNormalizado);
        if (categoriaExistente != null) {
            throw new ValidacaoException("Categoria já existe.");
        }
        categoria.setNome(nomeNormalizado);
        return categoriaRepository.save(categoria);
    }

    // Outros métodos do serviço
}