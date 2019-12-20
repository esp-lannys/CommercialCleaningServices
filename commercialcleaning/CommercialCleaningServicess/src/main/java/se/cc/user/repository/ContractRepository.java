package se.cc.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import se.cc.user.model.Contract;
import se.cc.user.model.User;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long>, CrudRepository<Contract, Long>{
	Contract findById(long id);

	
}
