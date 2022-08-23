package br.com.andersillva.gameflixpedidoapi.messagebroker.outgoing;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import br.com.andersillva.gameflixpedidoapi.domain.model.Pedido;
import br.com.andersillva.gameflixpedidoapi.messagebroker.outgoing.dto.MensagemPedidoRecebidoDTO;
import br.com.andersillva.gameflixpedidoapi.messagebroker.outgoing.exception.FalhaSerializacaoMensagemException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EventoPedidoRecebidoImpl implements EventoPedidoRecebido {

	private final KafkaTemplate<String, String> kafkaTemplate;
	private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @Value("${app.topic.pedido-recebido}")
    private String PEDIDO_RECEBIDO;

    public EventoPedidoRecebidoImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

	@Override
	@Transactional(propagation=Propagation.MANDATORY)
	public void gerarMensagem(Pedido pedido) {
		ModelMapper mapper = new ModelMapper();
		MensagemPedidoRecebidoDTO mensagemDTO = mapper.map(pedido, MensagemPedidoRecebidoDTO.class);
		String mensagem;
		try {
			mensagem = objectMapper.writeValueAsString(mensagemDTO);
		} catch (JsonProcessingException e) {
			log.error(e.getMessage());
			throw new FalhaSerializacaoMensagemException();
		}
        kafkaTemplate.send(PEDIDO_RECEBIDO, mensagem);
	}

}
