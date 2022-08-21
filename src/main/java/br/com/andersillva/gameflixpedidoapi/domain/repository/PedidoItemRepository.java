package br.com.andersillva.gameflixpedidoapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.andersillva.gameflixpedidoapi.domain.model.PedidoItem;

@Repository
public interface PedidoItemRepository  extends JpaRepository<PedidoItem, Long> {

}
