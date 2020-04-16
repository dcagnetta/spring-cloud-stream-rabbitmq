package co.za.codeboss.cloudstreamconsumerrabbitmq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface TestSink {
    String CHANNEL = "testChannel";

    @Input(CHANNEL)
    SubscribableChannel test();
}
