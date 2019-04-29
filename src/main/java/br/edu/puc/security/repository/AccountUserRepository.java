package br.edu.puc.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.puc.security.model.AccountUser;

public interface AccountUserRepository extends JpaRepository<AccountUser, Long>{
	
	AccountUser findByName(String name);

}
