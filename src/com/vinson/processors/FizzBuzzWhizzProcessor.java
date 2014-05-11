/**
 * 
 */
package com.vinson.processors;


import com.vinson.Entity;
import com.vinson.IConstants;

/**
 * @author VinsonCai
 *
 */
public class FizzBuzzWhizzProcessor extends AbstractProcessor {

	public FizzBuzzWhizzProcessor(IProcessor pNextProcessor) {
		super(pNextProcessor);
	}

	@Override
	public String process(int pNum, Entity pEntity, String pPrevious) {
		String say = pPrevious;
		
		String numStr = String.valueOf(pNum);
		String firstStr = String.valueOf(pEntity.mFirst);
		if(numStr.indexOf(firstStr) >= 0){
			say = "Fizz";
			return say;
		}
		
		if(!IConstants.dEFAULT_STRING.equals(say)){
			return say;
		}
		
		return mNextProcessor.process(pNum, pEntity, pPrevious);
	}

}
