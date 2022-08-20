package br.com.andersillva.gameflixpedidoapi.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.andersillva.gameflixpedidoapi.controller.util.VersaoAPI;

@RestController
@RequestMapping(path=VersaoAPI.URI_BASE_V1, produces=MediaType.TEXT_PLAIN_VALUE)
public class HelloController {

	@GetMapping("/hello")
	public String hello() {
		return "Hello from pedido-api!";
	}

}