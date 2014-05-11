/**
 * 
 */
package com.vinson.processors;

import com.vinson.Entity;

/**
 * @author VinsonCai
 *
 */
public class WhizzProcessor extends AbstractProcessor{

	public WhizzProcessor(IProcessor pNextProcessor) {
		super(pNextProcessor);
	}

	@Override
	public String process(int pNum, Entity pEntity, String pPrevious) {
		String say = pPrevious;
		if(pNum % pEntity.mThird == 0 ){
			say += "Whizz";
		}
		return mNextProcessor.process(pNum, pEntity, say);
	}

}
