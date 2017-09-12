package cn.ce.common.freemarker;

import freemarker.core.Environment;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class FreemarkerExceptionHandler implements TemplateExceptionHandler {
	

		public void handleTemplateException(TemplateException arg0,
				Environment arg1, java.io.Writer arg2) throws TemplateException {
			System.out.println("freemark错误");
			
		}
	
	}
