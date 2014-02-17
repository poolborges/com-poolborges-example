package com.poolborges.example.eventhandling;

public class NumberReadListenerImpl implements NumberReadListener {
 
    Double totalSoFar = 0D;
 
    @Override
    public void numberRead(NumberReadEvent numberReadEvent) {
        totalSoFar += numberReadEvent.getNumber();
    }
 
    @Override
    public void numberStreamTerminated(NumberReadEvent numberReadEvent) {
        System.out.println("Sum of the number stream: " + totalSoFar);
    }
}
