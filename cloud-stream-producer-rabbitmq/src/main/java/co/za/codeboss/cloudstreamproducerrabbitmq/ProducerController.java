package co.za.codeboss.cloudstreamproducerrabbitmq;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    private MessageChannel messageChannel;

    public ProducerController(TestSource testSource) {
        messageChannel = testSource.testChannel();
    }

    @GetMapping("/greet/{name}")
    public String publish(@PathVariable String name) {
        var message = TestMessage.builder().name("Dillan").number(10).build();
        var payload = MessageBuilder.withPayload(message).build();

        messageChannel.send(payload);

        return "success";
    }
}
