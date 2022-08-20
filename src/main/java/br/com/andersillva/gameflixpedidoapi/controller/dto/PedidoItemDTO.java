package br.com.andersillva.gameflixpedidoapi.controller.dto;

import java.util.List;

import br.com.andersillva.gameflixpedidoapi.domain.model.PedidoItem;
import lombok.Data;

@Data
public class PedidoItemDTO {

	private Long idProduto;

	public PedidoItemDTO(PedidoItem item) {
		this.idProduto = item.getIdProduto();
	}

	
	
	
	public static List<PedidoItemDTO> converter(List<PedidoItem> itens) {
		return itens.stream().map(PedidoItemDTO::new).toList();
	}

}
