package br.com.andersillva.gameflixpedidoapi.domain.service;

import br.com.andersillva.gameflixpedidoapi.domain.model.Pedido;

public interface PedidoService {

	public void registrar(Pedido pedido);
	
	public void registrarPagamento(Long idPedido);

}
