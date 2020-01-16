package com.anglobal.julio.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.anglobal.julio.model.Account;
import com.anglobal.julio.model.Transaction;
import com.anglobal.julio.service.IAccountService;

@RestController
@RequestMapping("/account")
public class AccountRestController {

	@Autowired
	IAccountService accountService;
	
	@PostMapping("/transfer")
	public ResponseEntity<?> transfer(@RequestBody Transaction transaction){
		Map<String, Object> response = new HashMap<>();
		try {
			accountService.doTransfer(transaction);
			response.put("mensaje", "Transferencia realizada con exito!");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la transferencia");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get/{account}")
	public ResponseEntity<?> getBalance(@PathVariable Integer account){
		Map<String, Object> response = new HashMap<>();
		try {
			Account actualAccount = accountService.getBalance(account);
			if(actualAccount != null) {
				response.put("mensaje", "Consulta realizada con exito!");
				response.put("balance", actualAccount);
			} else {
				response.put("mensaje", "No existe la cuenta a consultar");
			}
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
