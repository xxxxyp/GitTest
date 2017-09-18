package yk.boxri.utils;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SubMessage {
	public String  subMessage(String message){
		Document doc = Jsoup.parse(message);
		Element UserInputtedTextMessage=doc.getElementById("UserInputtedText");
		String messageContent=null;
		if(UserInputtedTextMessage!=null){
			messageContent=UserInputtedTextMessage.text().toString();
		}
		return messageContent;
		
	}
	public String  subMessageUrl(String message){
		Document doc = Jsoup.parse(message);
		Elements links = doc.select("#area7Container td.cta-block a[href]");
		String url=links.attr("href");
		String transId=null;
		try {
        	url = java.net.URLDecoder.decode(url,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        Pattern p = Pattern.compile("[^\\?&]?transId=[^&]+");
        Matcher m = p.matcher(url);//strTmp替换成你的字符串
        while (m.find()) {
            String transIdStr=m.group();
            if(transIdStr!=null){
            	String [] dataStr = transIdStr.split("=");
	            transId=dataStr[1];
            }
        }
		return transId;
		
	}
}
