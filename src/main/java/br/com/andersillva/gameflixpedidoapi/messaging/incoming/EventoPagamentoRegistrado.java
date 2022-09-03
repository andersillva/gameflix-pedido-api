package br.com.andersillva.gameflixpedidoapi.messaging.incoming;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.andersillva.gameflixpedidoapi.domain.service.PedidoService;

@Component
public class EventoPagamentoRegistrado {

    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private final PedidoService pedidoService;

    public EventoPagamentoRegistrado(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @KafkaListener(topics = "${app.topic.pagamento-registrado}")
    @Transactional
    public void consume(@Payload String message, Acknowledgment ack) throws JsonProcessingException {

        var statusPedidoDTO = mapper.readValue(message, StatusPedidoDTO.class);
        pedidoService.registrarPagamento(statusPedidoDTO.getIdPedido());
        ack.acknowledge();

    }

}
