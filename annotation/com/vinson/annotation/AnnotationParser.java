package com.vinson.annotation;

import com.vinson.processors.IProcessor;

public class AnnotationParser {

	private static AnnotationParser sParser = new AnnotationParser();

	private AnnotationParser() {

	}

	public static AnnotationParser getInstance() {
		return sParser;
	}

	public IProcessor getProcessorChain(Class<? extends IProcessor> headProcessor) {
		IProcessor head = null;
		if (headProcessor != null) {
			try {
				head = headProcessor.newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}

		Class<? extends IProcessor> processorClass = headProcessor;
		IProcessor processor = head;
		while (processor != null) {
			if (processorClass.isAnnotationPresent(ProcessorAnnotation.class)) {
				ProcessorAnnotation annotation = processorClass.getAnnotation(ProcessorAnnotation.class);
				String nextClass = annotation.nextProcesorClass();
				String speakWord = annotation.speakWord();
				try {
					Class<? extends IProcessor> clazz = (Class<? extends IProcessor>) Class.forName(nextClass);
					IProcessor nextProcessor = clazz.newInstance();
					processor.setNextProcessor(nextProcessor);
					processor.setSpeakWord(speakWord);

					processor = nextProcessor;
					processorClass = clazz;
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			else {
				break;
			}
		}

		return head;
	}
}
