package br.com.andersillva.gameflixpedidoapi.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsuarioAutenticado implements UserDetails, GrantedAuthority {

	private static final long serialVersionUID = 1L;

	private Long idUsuario;

	private String email;

	public UsuarioAutenticado(Long idUsuario, String email) {
		this.idUsuario = idUsuario;
		this.email = email;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<>();
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getAuthority() {
		return null;
	}

	public Long getId() {
		return this.idUsuario;
	}

}
