package com.usp.esalq.tcc.domain.mapper;

import com.usp.esalq.tcc.domain.entity.PagamentoEntity;
import com.usp.esalq.tcc.domain.entity.PedidoEntity;
import com.usp.esalq.tcc.domain.entity.UsuarioEntity;
import com.usp.esalq.tcc.domain.model.pagamento.DadosPagamentoVO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-29T22:36:49-0300",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 21.0.4 (Eclipse Adoptium)"
)
@Component
public class PagamentoMapperImpl implements PagamentoMapper {

    @Override
    public PagamentoEntity toPagamentoEntity(DadosPagamentoVO dadosPagamentoVO, PedidoEntity pedido, UsuarioEntity usuario) {
        if ( dadosPagamentoVO == null && pedido == null && usuario == null ) {
            return null;
        }

        PagamentoEntity pagamentoEntity = new PagamentoEntity();

        if ( dadosPagamentoVO != null ) {
            pagamentoEntity.setFormaPagamento( dadosPagamentoVO.formaPagamento() );
        }
        pagamentoEntity.setPedido( pedido );
        pagamentoEntity.setUsuario( usuario );

        return pagamentoEntity;
    }
}
