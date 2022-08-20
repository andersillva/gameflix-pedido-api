package br.com.andersillva.gameflixpedidoapi.domain.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.andersillva.gameflixpedidoapi.domain.model.domaintype.StatusPedido;
import lombok.Data;

@Entity
@Table(name="pedido")
@Data
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_pedido", nullable=false)
	private Long id;

	@Column(name="id_usuario", nullable=false)
	@NotNull
	private Long idUsuario;

	@Column(name="dt_pedido", nullable=false)
	@NotNull
	private LocalDate data;

	@Column(name="tp_status", length=1, nullable=false)
	@NotNull
	private StatusPedido status;

	@OneToMany(mappedBy = "pedido")
	private List<PedidoItem> itens = new ArrayList<>();

}
