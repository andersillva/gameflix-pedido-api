package br.com.andersillva.gameflixpedidoapi.domain.model.domaintype.converter;

import javax.persistence.Converter;

import br.com.andersillva.gameflixpedidoapi.domain.model.domaintype.StatusPedido;

@Converter(autoApply = true)
public class StatusPedidoConverter extends DominioAbstractConverter<StatusPedido, String> {

    public StatusPedidoConverter() {
        super(StatusPedido.class);
    }

}
