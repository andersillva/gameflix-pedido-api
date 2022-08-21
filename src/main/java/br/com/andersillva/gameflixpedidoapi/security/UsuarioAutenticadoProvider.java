package br.com.andersillva.gameflixpedidoapi.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UsuarioAutenticadoProvider {

	public static UsuarioAutenticado obterUsuarioAutenticado() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return (UsuarioAutenticado) authentication.getPrincipal();
	}

}
