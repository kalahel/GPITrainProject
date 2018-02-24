package com.ucp.gpi.backend.utils;

/**
 * This class represent a Bounded Counter
 *
 * @author quentin-matthieu
 * @version 23012017
 */
public class BoundedCounter extends Counter {

    protected int min;
    protected int max;

    public BoundedCounter(int value, int min, int max) {
        super(value);
        this.min = min;
        this.max = max;
    }

    /**
     * This method increment the bounded counter
     */
    public void increment() {
        if (counter < max) {
            this.counter++;
        }
    }

    /**
     * This methode increment the bounded counter time times
     */

    public void increment(int time) {
        for (int i = 0; i < time; i++) {
            if (counter < max) {
                this.counter++;
            }
        }
    }

    /**
     * This method decrement the bounded counter
     */
    public void decrement() {
        if (counter > min) {
            this.counter--;
        }
    }

    /**
     * This methode decrement the bounded counter time times
     */
    public void decrement(int time) {
        for (int i = 0; i < time; i++) {
            if (counter > min) {
                this.counter--;
            }
        }
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

}
