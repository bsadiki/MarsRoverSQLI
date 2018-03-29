package com.github.javadojo.path.drawer.position;

import static com.github.javadojo.config.Configuration.SAMPLE;

public class SamplePosition extends DrawerPosition {

    private static SamplePosition ourInstance = new SamplePosition();

    public static SamplePosition getInstance() {
        return ourInstance;
    }

    private SamplePosition() {
        super(5);
    }

    @Override
    public String draw() {
        return SAMPLE;
    }
}
