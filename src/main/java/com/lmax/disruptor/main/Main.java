package com.lmax.disruptor.main;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;

import java.nio.ByteBuffer;

public class Main {

    public static void main(String[] args) {

        EventMessageFactory factory = new EventMessageFactory();

        int bufferSize = 64;

        Disruptor<EventMessage> disruptor = new Disruptor<>(factory, bufferSize, DaemonThreadFactory.INSTANCE);

        disruptor.handleEventsWith(new EventMessageHandler());

        disruptor.start();

        RingBuffer<EventMessage> ringBuffer = disruptor.getRingBuffer();

        EventMessageProducer producer = new EventMessageProducer(ringBuffer);

        try {
            for (long l = 0; true; l++) {
                producer.onData(String.valueOf(l));
                System.out.println("product event: " + l);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
