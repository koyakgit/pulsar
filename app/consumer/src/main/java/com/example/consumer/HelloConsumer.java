package com.example.consumer;
import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.PulsarClient;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class HelloConsumer {

    public void doSample() throws Exception {

        PulsarClient pulsarClient = PulsarClient.builder()
                .serviceUrl("pulsar://192.168.3.3:6650")
                .build();

        Consumer<byte[]> consumer = pulsarClient.newConsumer()
                .topic("persistent://my-tenant/my-namespace/my-topic")
                .subscriptionName("my-subscribtion-name")
                .subscribe();

        for (int i = 0; i < 10; i++) {
            // メッセージを受信する
            Message<?> msg = consumer.receive();
            log.info("Received message: " + new String(msg.getData()));

            // BrokerにACKを返す
            consumer.acknowledge(msg);
        }

        pulsarClient.close();

    }
}
