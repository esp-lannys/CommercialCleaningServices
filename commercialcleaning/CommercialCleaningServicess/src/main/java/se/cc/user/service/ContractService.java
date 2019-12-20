package se.cc.user.service;

import se.cc.user.model.Contract;
import se.cc.user.webdto.ContractDto;

public interface ContractService {

	Contract save(ContractDto contract);
	
	
}
