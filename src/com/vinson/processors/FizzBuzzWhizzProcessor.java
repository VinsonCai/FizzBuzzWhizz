/**
 * 
 */
package com.vinson.processors;

import com.vinson.Entity;
import com.vinson.IConstants;
import com.vinson.annotation.ProcessorAnnotation;

/**
 * @author VinsonCai
 * 
 */
@ProcessorAnnotation(speakWord = "Fizz", nextProcesorClass = "com.vinson.processors.DefaultProcessor")
public class FizzBuzzWhizzProcessor extends AbstractProcessor {

	@Override
	public String process(int pNum, Entity pEntity, String pPrevious) {
		String say = pPrevious;

		String numStr = String.valueOf(pNum);
		String firstStr = String.valueOf(pEntity.mFirst);
		if (numStr.indexOf(firstStr) >= 0) {
			say = mSpeakWord;
			return say;
		}

		if (!IConstants.dEFAULT_STRING.equals(say)) {
			return say;
		}

		return mNextProcessor.process(pNum, pEntity, pPrevious);
	}

}
