/**
 * 
 */
package com.vinson.processors;

import com.vinson.Entity;

/**
 * @author VinsonCai
 *
 */
public class FizzProcessor extends AbstractProcessor{

	public FizzProcessor(IProcessor pNextProcessor) {
		super(pNextProcessor);
	}

	@Override
	public String process(int pNum, Entity pEntity, String pPrevious) {
		String say = pPrevious;
		if(pNum % pEntity.mFirst == 0){
			say += "Fizz";
		}
		return mNextProcessor.process(pNum, pEntity, say);
	}

}
