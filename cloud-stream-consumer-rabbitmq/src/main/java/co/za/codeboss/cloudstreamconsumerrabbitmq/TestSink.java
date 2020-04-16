package co.za.codeboss.cloudstreamconsumerrabbitmq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface TestSink {
    public String TEST_SOURCE = "test-source";

    @Input(TEST_SOURCE)
    SubscribableChannel test();
}
