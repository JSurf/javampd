package org.bff.javampd;

import java.time.LocalDateTime;

import javax.inject.Inject;

public class MPDSystemClock implements Clock {
	
	@Inject
	public MPDSystemClock() {
	}

	@Override
    public LocalDateTime now() {
        return LocalDateTime.now();
    }

    @Override
    public LocalDateTime min() {
        return LocalDateTime.MIN;
    }
}
