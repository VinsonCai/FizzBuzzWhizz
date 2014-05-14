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
@ProcessorAnnotation(speakWord = "Whizz", nextProcesorClass = "com.vinson.processors.FizzBuzzWhizzProcessor")
public class WhizzProcessor extends AbstractProcessor {

	@Override
	public String process(int pNum, Entity pEntity, String pPrevious) {
		String say = pPrevious;
		if (pNum % pEntity.mThird == 0) {
			say += mSpeakWord;
		}
		return mNextProcessor.process(pNum, pEntity, say);
	}

}
