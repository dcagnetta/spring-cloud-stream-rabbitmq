package co.za.codeboss.cloudstreamproducerrabbitmq;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class TestMessage {
    private String name;
    private int number;
}
