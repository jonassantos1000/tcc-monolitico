package com.usp.esalq.tcc.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usp.esalq.tcc.domain.model.pagamento.DadosPagamentoVO;
import com.usp.esalq.tcc.services.PagamentoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pagamentos")
@RequiredArgsConstructor
public class PagamentoController {

	private final PagamentoService pagamentoService;
	
	@PostMapping
	private void informarPagamento(@RequestBody DadosPagamentoVO dadosPagamento) {
		pagamentoService.registrarPagamento(dadosPagamento);
	}
	
	@PostMapping
	private void estornarPagamento(@RequestBody DadosPagamentoVO dadosPagamento) {
		pagamentoService.estornarPagamento(dadosPagamento);
	}
}
