package com.github.javadojo;

import static com.github.javadojo.MarsRover.LINE_SEPARATOR;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class MarsRoverTest {
    /**
    * The Mars rover is programmed to drive around Mars. Its programming is very simple. The commands are the following:

    s drive in a straight line
    r turn right
    l turn left
    S take a sample
    Note that the Mars rover always land at the X and starts by facing east.

    The Mars rover can send a 2D string representation of its path back to Mission Control. The following character are used with the following meanings:

    X where the Mars rover landed
    * current position of the Mars rover
    - path in the west-east direction
    | path in the north-south direction
    + a place where the Mars rover turned or a crossroad
    S a place where a sample was taken
    Your goal is to implement the MarsRover class to make all tests pass.
    */

    @Test
    public void driveEast() {
        assertThat(new MarsRover("s").path(), equalTo("X*" + LINE_SEPARATOR));
    }

    @Test
    public void driveEastForABitLonger() {
        assertThat(new MarsRover("ssss").path(), equalTo("X---*"
                + LINE_SEPARATOR));
    }

    @Test
    public void driveNorth() {
        String expectedPath = new StringBuilder().append("*")
                .append(LINE_SEPARATOR).append("|").append(LINE_SEPARATOR)
                .append("|").append(LINE_SEPARATOR).append("X")
                .append(LINE_SEPARATOR).toString();
        System.out.println(expectedPath);
        assertThat(new MarsRover("lsss").path(), equalTo(expectedPath));
    }

    @Test
    public void driveEstThanTurnLeft() {
        String expectedPath = new StringBuilder().append("    *")
                .append(LINE_SEPARATOR).append("    |").append(LINE_SEPARATOR)
                .append("    |").append(LINE_SEPARATOR).append("    |")
                .append(LINE_SEPARATOR).append("X---+").append(LINE_SEPARATOR)
                .toString();
        System.out.println(expectedPath);
        assertThat(new MarsRover("sssslssss").path(), equalTo(expectedPath));
    }

    @Test
    public void driveNorthAfterInitialProgrammingToTheEast() {
        MarsRover rover = new MarsRover("ssss").turnLeft().moveForward()
                .moveForward();
        String expectedPath = new StringBuilder().append("    *")
                .append(LINE_SEPARATOR).append("    |").append(LINE_SEPARATOR)
                .append("X---+").append(LINE_SEPARATOR).toString();
        System.out.println(expectedPath);
        assertThat(rover.path(), equalTo(expectedPath));
    }

    @Test
    public void driveEastThanTakeSampleThanDriveABitMore() {
        assertThat(new MarsRover("sssSsss").path(), equalTo("X--S--*"
                + LINE_SEPARATOR));
    }

    @Test
    public void turnRightTwoTimes() {
        MarsRover marsRover = new MarsRover("sssrsss").turnRight()
                .moveForward().moveForward().moveForward();
        String expectedPath = new StringBuilder().append("X--+")
                .append(LINE_SEPARATOR).append("   |").append(LINE_SEPARATOR)
                .append("   |").append(LINE_SEPARATOR).append("*--+")
                .append(LINE_SEPARATOR).toString();
        System.out.println(expectedPath);
        assertThat(marsRover.path(), equalTo(expectedPath));
    }

    @Test
    public void pathOverlapsAreMarkedWithRightCursor() {
        MarsRover marsRover = new MarsRover("ssssssrsss").turnRight()
                .moveForward().moveForward().moveForward().turnRight()
                .moveForward().moveForward().moveForward().moveForward();

        String expectedPath = new StringBuilder().append("   *   ")
                .append(LINE_SEPARATOR).append("X--+--+")
                .append(LINE_SEPARATOR).append("   |  |")
                .append(LINE_SEPARATOR).append("   |  |")
                .append(LINE_SEPARATOR).append("   +--+")
                .append(LINE_SEPARATOR).toString();
        System.out.println(expectedPath);
        assertThat(marsRover.path(), equalTo(expectedPath));
    }

    @Test
    public void samplePointIsNotOverridenOnSecondPass() {
        String expectedPath = new StringBuilder().append("   *   ")
                .append(LINE_SEPARATOR).append("X--S--+")
                .append(LINE_SEPARATOR).append("   |  |")
                .append(LINE_SEPARATOR).append("   |  |")
                .append(LINE_SEPARATOR).append("   +--+")
                .append(LINE_SEPARATOR).toString();
        System.out.println(expectedPath);
        assertThat(new MarsRover("sssSsssrsssrsssrssss").path(),
                equalTo(expectedPath));
    }

    @Test
    public void samplePointIsOverridenByCurrentPosition() {
        String expectedPath = new StringBuilder().append("X--*--+")
                .append(LINE_SEPARATOR).append("   |  |")
                .append(LINE_SEPARATOR).append("   |  |")
                .append(LINE_SEPARATOR).append("   +--+")
                .append(LINE_SEPARATOR).toString();
        System.out.println(expectedPath);
        assertThat(new MarsRover("sssSsssrsssrsssrsss").path(),
                equalTo(expectedPath));
    }

    @Test
    public void startPointIsNotOverridenOnSecondPass() {
        String expectedPath = new StringBuilder().append("*   ")
                .append(LINE_SEPARATOR).append("X--+").append(LINE_SEPARATOR)
                .append("|  |").append(LINE_SEPARATOR).append("|  |")
                .append(LINE_SEPARATOR).append("+--+").append(LINE_SEPARATOR)
                .toString();
        System.out.println(expectedPath);
        assertThat(new MarsRover("sssrsssrsssrssss").path(),
                equalTo(expectedPath));
    }

    @Test
    public void startPointIsOverridenByCurrentPosition() {
        String expectedPath = new StringBuilder().append("*--+")
                .append(LINE_SEPARATOR).append("|  |").append(LINE_SEPARATOR)
                .append("|  |").append(LINE_SEPARATOR).append("+--+")
                .append(LINE_SEPARATOR).toString();
        System.out.println(expectedPath);
        assertThat(new MarsRover("sssrsssrsssrsss").path(),
                equalTo(expectedPath));
    }

    @Test
    public void intermediatePathCanBeSent() {
        MarsRover marsRover = new MarsRover("sss");
        String intermadiatePath = marsRover.path();
        System.out.println(intermadiatePath);

        marsRover.moveForward().moveForward();
        String finalPath = marsRover.path();
        System.out.println(finalPath);

        assertThat(intermadiatePath, equalTo("X--*" + LINE_SEPARATOR));
        assertThat(finalPath, equalTo("X----*" + LINE_SEPARATOR));
    }
}
