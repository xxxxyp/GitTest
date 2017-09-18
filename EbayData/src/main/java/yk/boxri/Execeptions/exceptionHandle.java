package yk.boxri.Execeptions;

import org.apache.log4j.Logger;

public class exceptionHandle {
	
	public static Logger log = Logger.getLogger(exceptionHandle.class);
	
	public final static String TimeoutException = "TimeoutException";
	public final static String DBException= "DBException";
	public final static String UnexpectedException= "UnexpectedException";
	public final static String sdkException= "sdkException";
	
	public static String ExceptionHandle(Exception e,String logmsg)
	{
		String msg =e.toString();
		String error = e.toString();
		if(error.indexOf("timed out") != -1 || error.indexOf("Timeout") != -1)//��ʱ�쳣��ֱ�Ӻ��ԣ������������������
		{
			log.info("TimeoutException with "+logmsg);
			return TimeoutException;
		}
		else if(error.indexOf("JsonMappingException") != -1 ||
				error.indexOf("IOException") != -1 ||
				error.indexOf("IllegalArgumentException")!= -1 ||
				error.indexOf("IllegalAccessException") !=-1)
		{
			log.info("Error in LoadData2DB with "+logmsg + e.toString());
			return DBException;
		}
		else if(error.indexOf("sdk") != -1 )
		{
			log.info("Ebay sdkException"+logmsg + e.toString());
			return TimeoutException;
		}
		{
			log.info("UnexpectedException with"+logmsg + e.toString());
		}
		return UnexpectedException;
	}
}
