package com.upc.festisolutions.interfaces;
import com.upc.festisolutions.dto.ValoracionEventoDTO;
import java.util.List;

public interface IValoracionEventoService {
    public ValoracionEventoDTO alternarFavorito(Integer idAnfitrion, Integer idEvento);
    public List<ValoracionEventoDTO> listarValoracionEventoPorAnfitrion(Integer idAnfitrion);
    public ValoracionEventoDTO alternarFavoritoContrato(Integer idAnfitrion, Integer idContratoEvento);
}
