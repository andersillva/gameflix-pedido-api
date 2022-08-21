package br.com.andersillva.gameflixpedidoapi.domain.service.exception;

public class PedidoSemItensException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private static final String MENSAGEM_PADRAO = "Nenhum item foi adicionado ao pedido.";

	public PedidoSemItensException() {
        super(MENSAGEM_PADRAO);
    }

	public PedidoSemItensException(String mensagem) {
        super(mensagem);
    }

}
