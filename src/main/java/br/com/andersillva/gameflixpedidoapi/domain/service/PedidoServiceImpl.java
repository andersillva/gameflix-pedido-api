package br.com.andersillva.gameflixpedidoapi.domain.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.andersillva.gameflixpedidoapi.domain.model.Pedido;
import br.com.andersillva.gameflixpedidoapi.domain.model.domaintype.StatusPedido;
import br.com.andersillva.gameflixpedidoapi.domain.repository.PedidoItemRepository;
import br.com.andersillva.gameflixpedidoapi.domain.repository.PedidoRepository;
import br.com.andersillva.gameflixpedidoapi.domain.service.exception.PedidoSemItensException;
import br.com.andersillva.gameflixpedidoapi.domain.service.exception.RegistroNaoEncontradoException;
import br.com.andersillva.gameflixpedidoapi.messagebroker.outgoing.EventoPedidoRecebido;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PedidoItemRepository pedidoItemRepository;
	
	@Autowired
	private EventoPedidoRecebido eventoPedidoRecebido;

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void registrar(Pedido pedido) {

		if (pedido.getItens().isEmpty())
			throw new PedidoSemItensException();

		pedido.setId(null);
		pedido.setStatus(StatusPedido.RECEBIDO);
		pedido.setData(LocalDate.now());

		pedidoRepository.save(pedido);
		pedido.getItens().forEach(item -> item.setPedido(pedido));
		pedidoItemRepository.saveAll(pedido.getItens());
		eventoPedidoRecebido.gerarMensagem(pedido);

	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void registrarPagamento(Long idPedido) {

		Optional<Pedido> optPedido = pedidoRepository.findById(idPedido);
		if (!optPedido.isPresent()) 
			throw new RegistroNaoEncontradoException("Pedido não localizado.");
		
		Pedido pedido = optPedido.get();
		pedido.setStatus(StatusPedido.PAGAMENTO_REGISTRADO);
		pedidoRepository.save(pedido);

	}

}