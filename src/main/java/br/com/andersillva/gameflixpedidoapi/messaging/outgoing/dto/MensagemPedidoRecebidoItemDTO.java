package br.com.andersillva.gameflixpedidoapi.messaging.outgoing.dto;

import br.com.andersillva.gameflixpedidoapi.domain.model.PedidoItem;
import lombok.Data;

@Data
public class MensagemPedidoRecebidoItemDTO {

	private Long idProduto;

	public MensagemPedidoRecebidoItemDTO(PedidoItem pedidoItem) {
		this.idProduto = pedidoItem.getIdProduto();
	}

}
