package br.com.andersillva.gameflixpedidoapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.andersillva.gameflixpedidoapi.controller.form.PedidoForm;
import br.com.andersillva.gameflixpedidoapi.controller.util.VersaoAPI;
import br.com.andersillva.gameflixpedidoapi.domain.model.Pedido;
import br.com.andersillva.gameflixpedidoapi.domain.service.PedidoService;

@RestController
@RequestMapping(path=VersaoAPI.URI_BASE_V1, produces=MediaType.APPLICATION_JSON_VALUE)
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> registrar(@Valid @RequestBody PedidoForm pedidoForm) {

		Pedido pedido = pedidoForm.converter();
		pedidoService.registrar(pedido);
		return ResponseEntity.status(HttpStatus.CREATED).build();

	}

}
