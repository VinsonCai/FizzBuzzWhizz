/**
 * 
 */
package com.vinson.processors;

/**
 * @author VinsonCai
 * 
 */
public abstract class AbstractProcessor implements IProcessor {

	protected IProcessor mNextProcessor;
	protected String mSpeakWord;

	public AbstractProcessor() {
	}

	@Override
	public void setNextProcessor(IProcessor pNext) {
		mNextProcessor = pNext;
	}

	@Override
	public void setSpeakWord(String pWord) {
		mSpeakWord = pWord;
	}

}
