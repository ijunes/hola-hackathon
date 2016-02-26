package com.eharmony.hola.util;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * Created by jkang on 2/26/16.
 */
public enum EventBus {

    INSTANCE;

    // Use this with caution
    private static Bus UnsafeBus = new Bus(ThreadEnforcer.ANY);

    private static Bus defaultBus = new Bus();

    public Bus getBus() {
        return defaultBus;
    }

    public Bus getUnsafeBus() {
        return UnsafeBus;
    }
}
