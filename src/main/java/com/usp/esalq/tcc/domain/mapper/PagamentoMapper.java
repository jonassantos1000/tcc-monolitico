package com.usp.esalq.tcc.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.usp.esalq.tcc.domain.entity.PagamentoEntity;
import com.usp.esalq.tcc.domain.entity.PedidoEntity;
import com.usp.esalq.tcc.domain.entity.UsuarioEntity;
import com.usp.esalq.tcc.domain.model.pagamento.DadosPagamentoVO;

@Mapper(componentModel = "spring")
public interface PagamentoMapper {
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "pedido", source = "pedido")
	@Mapping(target = "usuario", source = "usuario")
	PagamentoEntity toPagamentoEntity(DadosPagamentoVO dadosPagamentoVO, PedidoEntity pedido, UsuarioEntity usuario);
}
