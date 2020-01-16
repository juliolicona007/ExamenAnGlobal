package com.anglobal.julio.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.anglobal.julio.model.Transaction;
import com.anglobal.julio.service.ITransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionRestController {

	@Autowired
	ITransactionService transactionService;
	
	@GetMapping("/getAll/{account}")
	public ResponseEntity<?> getAll(@PathVariable Integer account){
		Map<String, Object> response = new HashMap<>();
		try {
			List<Transaction> listaTransacciones = transactionService.historyAll(account);
			if(listaTransacciones != null && !listaTransacciones.isEmpty()) {
				response.put("mensaje", "Consulta realizada con exito!");
				response.put("transactions", listaTransacciones);
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
	
	@GetMapping("/getReceived/{account}")
	public ResponseEntity<?> getReceived(@PathVariable Integer account){
		Map<String, Object> response = new HashMap<>();
		try {
			List<Transaction> listaTransacciones = transactionService.historyReceived(account);
			if(listaTransacciones != null && !listaTransacciones.isEmpty()) {
				response.put("mensaje", "Consulta realizada con exito!");
				response.put("transactions", listaTransacciones);
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
	
	@GetMapping("/getSent/{account}")
	public ResponseEntity<?> getSent(@PathVariable Integer account){
		Map<String, Object> response = new HashMap<>();
		try {
			List<Transaction> listaTransacciones = transactionService.historySent(account);
			if(listaTransacciones != null && !listaTransacciones.isEmpty()) {
				response.put("mensaje", "Consulta realizada con exito!");
				response.put("transactions", listaTransacciones);
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
