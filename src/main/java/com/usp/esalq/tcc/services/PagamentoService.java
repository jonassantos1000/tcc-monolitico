package com.usp.esalq.tcc.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usp.esalq.tcc.domain.entity.PedidoEntity;
import com.usp.esalq.tcc.domain.mapper.PagamentoMapper;
import com.usp.esalq.tcc.domain.model.pagamento.DadosPagamentoVO;
import com.usp.esalq.tcc.repository.PagamentoRepository;
import com.usp.esalq.tcc.utils.SecurityContextUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PagamentoService {
	
	private final PagamentoMapper mapper;
	
	private final PedidoService pedidoService;
	
	private final PagamentoRepository pagamentoRepository;
	
	@Transactional
	public void registrarPagamento(DadosPagamentoVO dadosPagamento) {
		PedidoEntity pedido = pedidoService.getById(dadosPagamento.pedidoId());
		pagamentoRepository.save(mapper.toPagamentoEntity(dadosPagamento, pedido, SecurityContextUtils.getUsuario()));
		pedidoService.confirmarPagamento(pedido);
	}

	@Transactional
	public void estornarPagamento(DadosPagamentoVO dadosPagamento) {
		PedidoEntity pedido = pedidoService.getById(dadosPagamento.pedidoId());
		pedidoService.estornarPagamento(pedido);
		pagamentoRepository.delete(pedido.getPagamento());
	}
	
}
