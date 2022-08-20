package br.com.andersillva.gameflixpedidoapi.domain.model.domaintype;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
public enum StatusPedido implements Dominio<String> {

	RECEBIDO("R"),
	PAGAMENTO_REGISTRADO("P"),
	PAGAMENTO_NAO_REGISTRADO("N"),
	ENTREGUE("E"),
	CANCELADO("C");

	@Getter
	private String valor;

}
