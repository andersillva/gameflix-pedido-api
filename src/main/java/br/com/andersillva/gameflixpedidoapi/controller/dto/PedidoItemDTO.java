package br.com.andersillva.gameflixpedidoapi.controller.dto;

import java.util.List;

import org.modelmapper.ModelMapper;

import br.com.andersillva.gameflixpedidoapi.domain.model.PedidoItem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PedidoItemDTO {

	private static ModelMapper mapper = new ModelMapper();

	private Long idProduto;

	public PedidoItemDTO(PedidoItem item) {
		this.idProduto = item.getIdProduto();
	}

	public PedidoItem converter() {
		return mapper.map(this, PedidoItem.class);
	}

	public static List<PedidoItemDTO> converter(List<PedidoItem> itens) {
		return itens.stream().map(PedidoItemDTO::new).toList();
	}

}
