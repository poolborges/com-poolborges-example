package com.poolborges.example.eventhandling;

import java.io.Console;
import java.util.HashSet;
import java.util.Set;
 
public class NumberReader {
    private Set<NumberReadListener> listeners;
 
    public NumberReader() {
        listeners = new HashSet<NumberReadListener>();
    }
 
    public void addNumberReadListener(NumberReadListener listener) {
        this.listeners.add(listener);
    }
 
    public void removeNumberReadListener(NumberReadListener listener) {
        this.listeners.remove(listener);
    }
 
    public void start() {
        Console console = System.console();
        if (console != null) {
            Double d = null;
            do {
                String readLine = console.readLine("Enter a number: ", (Object[])null);
                d = getDoubleValue(readLine);
                if (d != null) {
                    notifyListeners(d);
                }
            } while (d != null);
            notifyListenersOfEndOfStream();
        }
    }
 
    private void notifyListenersOfEndOfStream() {
        for (NumberReadListener numberReadListener: listeners) {
            numberReadListener.numberStreamTerminated(new NumberReadEvent(this, 0D));
        }
    }
 
    private void notifyListeners(Double d) {
        for (NumberReadListener numberReadListener: listeners) {
            numberReadListener.numberRead(new NumberReadEvent(this, d));
        }
    }
 
    private Double getDoubleValue(String readLine) {
        Double result;
        try {
            result = Double.valueOf(readLine);
        } catch (Exception e) {
            result = null;
        }
        return result;
    }
}
