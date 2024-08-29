package kr.or.ddit.basic;

import org.apache.log4j.Logger;

public class Log4JTest {

	static Logger logger = Logger.getLogger(Log4JTest.class);
	
	public static void main(String[] args) {
		// SET LOGGING MESSAGE
		// format) LoggerObject.LogLevel("<message>");
		
//		logger.trace("this is trace message");
//		logger.debug("this is debug level message");
//		logger.info("this is info level message");
//		logger.warn("warning, yes this is also a level and it is 4th. of course this is a warning");
//		logger.error("the 5th log level, the error. this is about an error");
//		logger.fatal("this name doesn't look good, this is the last one, the FATAL. this is the severe error");
		logger.fatal("test for non stdout, logfile only. do it four times");
		
		
		
	}
}
