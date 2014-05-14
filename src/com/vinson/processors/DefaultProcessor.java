/**
 * 
 */
package com.vinson.processors;

import com.vinson.Entity;

/**
 * @author VinsonCai
 * 
 */
public class DefaultProcessor extends AbstractProcessor {

	@Override
	public String process(int pNum, Entity pEntity, String pPrevious) {
		return String.valueOf(pNum);
	}

}
