package fr.lafactory.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import fr.lafactory.model.Role;
import fr.lafactory.model.Utilisateur;

public class UtilisateurPrincipal implements UserDetails  {
	
	private static final long serialVersionUID = 1L;
	
	private Utilisateur utilisateur;
	
	public UtilisateurPrincipal(Utilisateur utilisateur) {
		
	if (utilisateur == null) {
		throw new UsernameNotFoundException("Ce nom d'utilisateur n'existe pas.");
	}
		this.utilisateur = utilisateur;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> myAuthorities = new ArrayList<GrantedAuthority>();
		
		if(utilisateur.getRole().equals(Role.ADMINISTRATEUR)) {
			myAuthorities.add(new SimpleGrantedAuthority("ADMINISTRATEUR"));
		}
		else if(utilisateur.getRole().equals(Role.TECHNICIEN)){
			myAuthorities.add(new SimpleGrantedAuthority("TECHNICIEN"));
		}
		else {
			myAuthorities.add(new SimpleGrantedAuthority("VISITEUR"));
		}
		
		
		return myAuthorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.utilisateur.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.utilisateur.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
