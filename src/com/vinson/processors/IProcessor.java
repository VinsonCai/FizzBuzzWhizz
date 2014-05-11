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

	public String process(int pNum, Entity pEntity, String pPrevious);
}
