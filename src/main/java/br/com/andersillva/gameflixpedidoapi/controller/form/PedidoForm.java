package br.com.andersillva.gameflixpedidoapi.controller.form;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import br.com.andersillva.gameflixpedidoapi.controller.dto.PedidoItemDTO;
import br.com.andersillva.gameflixpedidoapi.domain.model.Pedido;
import lombok.Data;

@Data
public class PedidoForm {

	private static ModelMapper mapper = new ModelMapper();

	@NotNull
	private List<PedidoItemDTO> itens;

	public Pedido converter() {
		return mapper.map(this, Pedido.class);
	}

}
