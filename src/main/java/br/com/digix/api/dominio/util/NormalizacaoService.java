package br.com.digix.api.dominio.util;

import org.springframework.stereotype.Service;

import java.text.Normalizer;

@Service
public class NormalizacaoService {

    public String normalizarString(String input) {
        String normalizedString = Normalizer.normalize(input, Normalizer.Form.NFD);
        normalizedString = normalizedString.replaceAll("[^\\p{ASCII}]", "");
        return normalizedString.toLowerCase();
    }
}
