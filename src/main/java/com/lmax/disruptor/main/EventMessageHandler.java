package com.lmax.disruptor.main;

import com.lmax.disruptor.EventHandler;

public class EventMessageHandler implements EventHandler<EventMessage> {

    @Override
    public void onEvent(EventMessage event, long sequence, boolean endOfBatch) {
        System.out.println("Event: " + event.getMsg());
    }
}
