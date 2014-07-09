package org.bigtester.AutomationTestEngine;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class ModifyTestInvocation implements IAnnotationTransformer {
	
		@SuppressWarnings("rawtypes")
		public void transform(ITestAnnotation arg0, Class arg1, Constructor arg2,
			Method arg3) {
		if ("f".equals(arg3.getName())) {
			arg0.setInvocationCount(2);
		}
	}
}