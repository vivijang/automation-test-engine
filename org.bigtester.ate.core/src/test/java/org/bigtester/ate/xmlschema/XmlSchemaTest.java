package org.bigtester.ate.xmlschema;


import java.text.SimpleDateFormat;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Assert;
import org.testng.annotations.Test;

public class XmlSchemaTest {
  @Test
  public void f() {
	  ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"XmlSchemaTest-applicationContext.xml");
	  
	  JobDetailTemplate jdt = (JobDetailTemplate) context.getBean("jobDetailTemplate");
	  SimpleDateFormat defaultDateFormat = (SimpleDateFormat) context.getBean("defaultDateFormat");
	  System.out.println(jdt.dateFormat.toPattern());
	  System.out.println(defaultDateFormat.toPattern());
	  
	  Assert.assertEquals(jdt.dateFormat.toPattern(), "HH:mm MM-dd-yyyy");
	  Assert.assertEquals(defaultDateFormat.toPattern(), "yyyy-MM-dd HH:mm");
	  context.close();
  }
}
