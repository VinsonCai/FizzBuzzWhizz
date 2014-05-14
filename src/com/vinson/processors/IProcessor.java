/**
 * 
 */
package com.vinson.processors;

import com.vinson.Entity;

/**
 * @author VinsonCai
 * 
 */
public interface IProcessor {

	void setNextProcessor(IProcessor pNext);

	void setSpeakWord(String pWord);

	String process(int pNum, Entity pEntity, String pPrevious);
}
