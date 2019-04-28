package br.edu.puc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.puc.model.AccountUser;

public interface AccountUserRepository extends JpaRepository<AccountUser, Long>{
	
	AccountUser findByName(String name);

}
