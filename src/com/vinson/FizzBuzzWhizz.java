/**
 * 
 */
package com.vinson;

import java.util.Scanner;

import com.vinson.processors.BuzzProcessor;
import com.vinson.processors.DefaultProcessor;
import com.vinson.processors.FizzBuzzWhizzProcessor;
import com.vinson.processors.FizzProcessor;
import com.vinson.processors.IProcessor;
import com.vinson.processors.WhizzProcessor;

/**
 * @author VinsonCai
 *
 */
public class FizzBuzzWhizz {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int first = cin.nextInt();
		int second = cin.nextInt();
		int third = cin.nextInt();
		Entity entity = new Entity(first, second, third);
		
		IProcessor processor = compositeProcessors();
		for(int i = 1; i<= 100; ++i){
			System.out.println(processor.process(i, entity, IConstants.dEFAULT_STRING));
		}
		cin.close();
	}
	
	private static IProcessor compositeProcessors(){
		IProcessor head= null;
		
		DefaultProcessor def = new DefaultProcessor(null);
		FizzBuzzWhizzProcessor fizzBuzzWhizzProcessor = new FizzBuzzWhizzProcessor(def);
		WhizzProcessor whizzProcessor = new WhizzProcessor(fizzBuzzWhizzProcessor);
		BuzzProcessor buzzProcessor = new BuzzProcessor(whizzProcessor);
		FizzProcessor fizzProcessor = new FizzProcessor(buzzProcessor);
		
		head = fizzProcessor;
		return head;
		
		
	}

}
