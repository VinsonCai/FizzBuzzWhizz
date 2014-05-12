/**
 * 
 */
package com.vinson;

import com.vinson.processors.BuzzProcessor;
import com.vinson.processors.DefaultProcessor;
import com.vinson.processors.FizzBuzzWhizzProcessor;
import com.vinson.processors.FizzProcessor;
import com.vinson.processors.IProcessor;
import com.vinson.processors.WhizzProcessor;

/**
 * @author VinsonCai
 * 
 */
public class FizzBuzzWhizz {

	private static final int DEFAULT_START = 1;
	private static final int DEFAULT_END = 100;
	private static final int DEFAULT_MAGIC_NUMBER = -1;

	private int mStart;
	private int mEnd;

	private int mFirst;
	private int mSecond;
	private int mThird;

	private FizzBuzzWhizz() {
		mStart = DEFAULT_START;
		mEnd = DEFAULT_END;

		mFirst = mSecond = mThird = DEFAULT_MAGIC_NUMBER;
	}

	public void run() {
		Entity entity = new Entity(mFirst, mSecond, mThird);
		IProcessor processor = compositeProcessors();
		for (int i = mStart; i <= mEnd; ++i) {
			System.out.println(processor.process(i, entity, IConstants.dEFAULT_STRING));
		}
	}

	private IProcessor compositeProcessors() {
		IProcessor head = null;

		DefaultProcessor def = new DefaultProcessor(null);
		FizzBuzzWhizzProcessor fizzBuzzWhizzProcessor = new FizzBuzzWhizzProcessor(def);
		WhizzProcessor whizzProcessor = new WhizzProcessor(fizzBuzzWhizzProcessor);
		BuzzProcessor buzzProcessor = new BuzzProcessor(whizzProcessor);
		FizzProcessor fizzProcessor = new FizzProcessor(buzzProcessor);

		head = fizzProcessor;
		return head;
	}

	public static class FizzBuzzWhizzBuilder {
		private FizzBuzzWhizz mFizzBuzzWhizz;

		public FizzBuzzWhizzBuilder() {
			mFizzBuzzWhizz = new FizzBuzzWhizz();
		}

		public FizzBuzzWhizzBuilder setStart(int pStart) {
			mFizzBuzzWhizz.mStart = pStart;
			return this;
		}

		public FizzBuzzWhizzBuilder setEnd(int pEnd) {
			mFizzBuzzWhizz.mEnd = pEnd;
			return this;
		}

		public FizzBuzzWhizzBuilder setMagicNumber(int pFirst, int pSecond, int pThird) {
			mFizzBuzzWhizz.mFirst = pFirst;
			mFizzBuzzWhizz.mSecond = pSecond;
			mFizzBuzzWhizz.mThird = pThird;
			return this;
		}

		public FizzBuzzWhizz create() {
			if (!validate()) {
				throw new IllegalArgumentException("Magic number is mandatery, and start/end is optional.");
			}
			return mFizzBuzzWhizz;
		}

		private boolean validate() {
			if (FizzBuzzWhizz.DEFAULT_MAGIC_NUMBER == mFizzBuzzWhizz.mFirst
					|| FizzBuzzWhizz.DEFAULT_MAGIC_NUMBER == mFizzBuzzWhizz.mSecond
					|| FizzBuzzWhizz.DEFAULT_MAGIC_NUMBER == mFizzBuzzWhizz.mThird) {
				return false;
			}
			return true;
		}
	}
}
