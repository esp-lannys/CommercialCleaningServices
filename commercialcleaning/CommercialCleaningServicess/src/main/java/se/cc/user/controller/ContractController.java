package se.cc.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import se.cc.user.service.ContractService;
import se.cc.user.webdto.ContractDto;

@Controller
public class ContractController {

	@Autowired
	private ContractService contractService;
	@ModelAttribute
	public ContractDto contractDto() {
		return new ContractDto();
	}
	
	@PreAuthorize("!(hasRole('EMPLOYEE') OR hasRole('ADMIN'))")
	@GetMapping("/user/contract")
	public String loadContract(Model model){
		model.addAttribute("contract", new ContractDto());
		return "contract";
	}
	
	@PostMapping("/user/contract/add")
	public String addContract(@ModelAttribute("contract") ContractDto contractdto, BindingResult result)
			throws Exception {
		if(result.hasErrors()) {
			return "/user/contract";
		}
		contractService.save(contractdto);
		return "redirect:/user/contract?success";
	}
}
