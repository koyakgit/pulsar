package com.example.provider;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.stereotype.Component;

@Component
public class HelloProducer {
    public void doSample() throws PulsarClientException {
        PulsarClient pulsarClient = PulsarClient.builder()
                .serviceUrl("pulsar://192.168.3.3:6650")
                .build();

        Producer<byte[]> producer = pulsarClient.newProducer()
                .topic("persistent://my-tenant/my-namespace/my-topic")
                .create();

        for (int i = 0; i < 10; i++) {
            // メッセージを送信する
            producer.send(String.format("my-message-%d", i).getBytes());
        }

        pulsarClient.close();

    }
}
