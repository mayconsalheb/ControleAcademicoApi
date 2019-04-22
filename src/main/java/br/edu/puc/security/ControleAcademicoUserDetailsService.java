package br.edu.puc.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class ControleAcademicoUserDetailsService implements UserDetailsService {
	private static List<UserObject> users = new ArrayList<>();
	
	@PostConstruct
	public void init() {
        users.add(new UserObject("flavio", "$2a$10$h3m/QiY7PxEa4nhoTevoceJlqOKtcD/tUPb9Rjf05HBypZBeWl0X.", "ADMIN"));
        users.add(new UserObject("joao", "$2a$10$h3m/QiY7PxEa4nhoTevoceJlqOKtcD/tUPb9Rjf05HBypZBeWl0X.", "ADMIN"));
    }
	
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserObject> user = users.stream()
                                         .filter(u -> u.name.equals(username))
                                         .findAny();
        if (!user.isPresent()) {
            throw new UsernameNotFoundException("User not found by name: " + username);
        }
        return toUserDetails(user.get());
    }

    private UserDetails toUserDetails(UserObject userObject) {
        return User.withUsername(userObject.name)
                   .password(userObject.password)
                   .roles(userObject.role).build();
    }

    private static class UserObject {
        private String name;
        private String password;
        private String role;

        public UserObject(String name, String password, String role) {
            this.name = name;
            this.password = password;
            this.role = role;
        }
    }
}
