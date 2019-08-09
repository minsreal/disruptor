package com.lmax.disruptor.main;

import com.lmax.disruptor.EventHandler;

public class EventMessageHandler implements EventHandler<EventMessage> {

    @Override
    public void onEvent(EventMessage event, long sequence, boolean endOfBatch) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("handle vent: " + event.getMsg());
    }
}
