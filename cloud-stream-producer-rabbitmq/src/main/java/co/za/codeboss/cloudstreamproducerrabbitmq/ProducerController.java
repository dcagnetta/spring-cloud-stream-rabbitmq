package co.za.codeboss.cloudstreamproducerrabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ProducerController {

    private MessageChannel messageChannel;

    public ProducerController(TestSource testSource) {
        messageChannel = testSource.testSourceChannel();
    }

    @GetMapping("/greet/{name}")
    public String publish(@PathVariable String name) {
        log.info("API received name: {}", name);
        var message = TestMessage.builder().name(name).number(10).build();
        var payload = MessageBuilder.withPayload(message).build();

        messageChannel.send(payload);

        return "success";
    }
}
