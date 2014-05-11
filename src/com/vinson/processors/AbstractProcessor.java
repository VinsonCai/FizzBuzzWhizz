/**
 * 
 */
package com.vinson.processors;

/**
 * @author VinsonCai
 *
 */
public abstract class AbstractProcessor implements IProcessor{

	protected IProcessor mNextProcessor;
	public AbstractProcessor(IProcessor pNextProcessor){
		mNextProcessor = pNextProcessor;
	}
}
