package com.lmax.disruptor.main;

import com.lmax.disruptor.EventFactory;

public class EventMessageFactory implements EventFactory<EventMessage> {

    @Override
    public EventMessage newInstance() {
        return new EventMessage();
    }
}
