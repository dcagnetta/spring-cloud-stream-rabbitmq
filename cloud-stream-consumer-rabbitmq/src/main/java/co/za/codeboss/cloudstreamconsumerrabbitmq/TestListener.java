package co.za.codeboss.cloudstreamconsumerrabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

@Slf4j
@EnableBinding(TestSink.class)
public class TestListener {

    @StreamListener(TestSink.TEST_SOURCE)
    public void log(Message<TestMessage> message){
        log.info("\n******************\nAt the Sink\n******************\n");
        log.info("Message received: {}", message);
        log.info("Name: {}", message.getPayload().getName());
    }
}
