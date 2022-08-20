package br.com.andersillva.gameflixpedidoapi.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.andersillva.gameflixpedidoapi.domain.model.Pedido;
import br.com.andersillva.gameflixpedidoapi.domain.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void registrar(Pedido pedido) {
		pedidoRepository.saveAndFlush(pedido);
	}

}
