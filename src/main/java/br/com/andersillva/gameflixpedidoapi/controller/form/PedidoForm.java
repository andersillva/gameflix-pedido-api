package br.com.andersillva.gameflixpedidoapi.controller.form;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import br.com.andersillva.gameflixpedidoapi.controller.dto.PedidoItemDTO;
import br.com.andersillva.gameflixpedidoapi.domain.model.Pedido;
import lombok.Data;

@Data
public class PedidoForm {

	@NotNull
	private List<PedidoItemDTO> itens = new ArrayList<>();

	public Pedido converter() {
		Pedido pedido = new Pedido();
		itens.forEach(item -> pedido.adicionarItem(item.converter()));
		return pedido;
	}

}
