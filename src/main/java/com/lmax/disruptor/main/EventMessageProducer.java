package com.lmax.disruptor.main;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;

public class EventMessageProducer {

    private final RingBuffer<EventMessage> ringBuffer;

    public EventMessageProducer(RingBuffer<EventMessage> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    private static final EventTranslatorOneArg<EventMessage, String> TRANSLATOR =
            new EventTranslatorOneArg<EventMessage, String>() {
                public void translateTo(EventMessage event, long sequence, String bb) {
                    event.setMsg(bb);
                }
            };

    public void onData(String bb) {
        ringBuffer.publishEvent(TRANSLATOR, bb);
    }
}
