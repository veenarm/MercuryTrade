package com.home.clicker.events.custom;

import com.home.clicker.events.SCEvent;
import com.home.clicker.ui.FrameStates;

/**
 * Created by Константин on 10.12.2016.
 */
public class ChangeFrameVisibleEvent implements SCEvent {
    private FrameStates states;

    public ChangeFrameVisibleEvent(FrameStates states) {
        this.states = states;
    }

    public FrameStates getStates() {
        return states;
    }
}
