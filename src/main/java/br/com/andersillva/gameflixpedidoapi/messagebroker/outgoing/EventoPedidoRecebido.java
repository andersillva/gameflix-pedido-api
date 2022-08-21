package br.com.andersillva.gameflixpedidoapi.messagebroker.outgoing;

import br.com.andersillva.gameflixpedidoapi.domain.model.Pedido;

public interface EventoPedidoRecebido {

	public void gerarMensagem(Pedido pedido);

}
