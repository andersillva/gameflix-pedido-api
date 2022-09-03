package br.com.andersillva.gameflixpedidoapi.messaging.outgoing.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import br.com.andersillva.gameflixpedidoapi.domain.model.Pedido;
import lombok.Data;

@Data
public class MensagemPedidoRecebidoDTO {

	private Long idPedido;

	private Long idUsuario;

	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate data;

	private List<MensagemPedidoRecebidoItemDTO> itens = new ArrayList<>();

	public MensagemPedidoRecebidoDTO(Pedido pedido) {
		this.idPedido = pedido.getId();
		this.idUsuario = pedido.getIdUsuario();
		this.data = pedido.getData();
		this.itens = pedido.getItens().stream().map(MensagemPedidoRecebidoItemDTO::new).collect(Collectors.toList());
	}

}
