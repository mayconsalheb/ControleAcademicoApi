package br.edu.puc.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.edu.puc.model.AccountUser;
import br.edu.puc.repository.AccountUserRepository;

@Component
public class ControleAcademicoUserDetailsService implements UserDetailsService {
	
	@Autowired
	private AccountUserRepository userRepository;
	
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	Optional<AccountUser> userObject = Optional.ofNullable(userRepository.findByName(username));
    	
        if (!userObject.isPresent()) {
            throw new UsernameNotFoundException("User not found by name: " + username);
        }
        return toUserDetails(userObject.get());
    }

    private UserDetails toUserDetails(AccountUser user) {
    	String[] roles =  (String[]) user.getRoles().stream().map(role->role.getName()).toArray(String[]::new);
        return User.withUsername(user.getName())
                   .password(user.getPassword())
                   .roles(roles)
                   .build();
    }
}
