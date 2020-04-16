package co.za.codeboss.cloudstreamproducerrabbitmq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface HelloBinding {
    @Output("greetingChannel")
    MessageChannel greeting();
}
