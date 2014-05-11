/**
 * 
 */
package com.vinson.processors;

import com.vinson.Entity;

/**
 * @author VinsonCai
 *
 */
public class BuzzProcessor extends AbstractProcessor{

	public BuzzProcessor(IProcessor pNextProcessor) {
		super(pNextProcessor);
	}

	@Override
	public String process(int pNum, Entity pEntity, String pPrevious) {
		String say = pPrevious;
		if(pNum % pEntity.mSecond == 0){
			say += "Buzz";
		}
		return mNextProcessor.process(pNum, pEntity, say);
	}

}
