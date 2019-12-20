package se.cc.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import se.cc.user.model.Contract;
import se.cc.user.repository.ContractRepository;
import se.cc.user.webdto.ContractDto;

@Service
@Transactional
public class ContractServiceImpl implements ContractService{
	@Autowired
	private ContractRepository contractRepository;

	@Override
	public Contract save(ContractDto contractdto) {
		Contract contract = new Contract();
		contract.setAddress(contractdto.getAddress());
		contract.setPackNumber(contractdto.getPackNumber());
		contract.setPhone(contractdto.getPhone());
		return contractRepository.save(contract);
	}
	
	
}
