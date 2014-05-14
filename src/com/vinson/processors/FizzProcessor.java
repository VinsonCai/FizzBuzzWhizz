/**
 * 
 */
package com.vinson.processors;

import com.vinson.Entity;
import com.vinson.annotation.ProcessorAnnotation;

/**
 * @author VinsonCai
 * 
 */

@ProcessorAnnotation(speakWord = "Fizz", nextProcesorClass = "com.vinson.processors.BuzzProcessor")
public class FizzProcessor extends AbstractProcessor {

	@Override
	public String process(int pNum, Entity pEntity, String pPrevious) {
		String say = pPrevious;
		if (pNum % pEntity.mFirst == 0) {
			say += mSpeakWord;
		}
		return mNextProcessor.process(pNum, pEntity, say);
	}

}
