package br.com.andersillva.gameflixpedidoapi.messagebroker.outgoing.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.andersillva.gameflixpedidoapi.domain.model.domaintype.StatusPedido;
import lombok.Data;

@Data
public class MensagemPedidoRecebidoDTO {

	private Long id;

	private Long idUsuario;

	private LocalDate data;

	private StatusPedido status;

	private List<PedidoItemDTO> itens = new ArrayList<>();

}
