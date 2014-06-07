/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.springscheduler.xml;


import com.poolborges.example.springscheduler.Processor;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;


import org.springframework.stereotype.Service;
/**
 *
 * @author PauloBorges
 */
@Service
public class SimpleProcessor implements Processor {

	private final AtomicInteger counter = new AtomicInteger();

	public void process() {
		System.out.println("processing next 10 at " + new Date());
		for (int i = 0; i < 10; i++) {
			System.out.println("   processing " + counter.incrementAndGet());
		}
	}

}
