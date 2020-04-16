package co.za.codeboss.cloudstreamproducerrabbitmq;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.support.MessageBuilder;

@EnableBinding(TestSource.class)
public class TestPublisher {


    @Bean
    public MessageSource<TestMessage> sendTestMessage() {
        var message = TestMessage.builder().name("Dillan").number(10).build();

        // MessageSource is a FunctionalInterface
        return () -> MessageBuilder.withPayload(message).build();
    }

}
