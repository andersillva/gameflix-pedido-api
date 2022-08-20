package br.com.andersillva.gameflixpedidoapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.andersillva.gameflixpedidoapi.domain.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
