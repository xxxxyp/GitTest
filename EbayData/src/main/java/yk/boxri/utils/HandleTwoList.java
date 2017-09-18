package yk.boxri.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandleTwoList {
	 public  List<String> searchDiffList(List<String> list1, List<String> list2) {  
	         List<String> diffList = new ArrayList<String>();  
	         List<String> maxList = list1;  
	         List<String> minList = list2;  
	         if(list2.size()>list1.size())  
	         {  
	             maxList = list2;  
	             minList = list1;  
	         }  
	         Map<String,Integer> map = new HashMap<String,Integer>(maxList.size());  
	         for (String string : maxList) {  
	             map.put(string, 1);  
	         }  
	         for (String string : minList) {  
	             if(map.get(string)!=null)  
	             {  
	                 map.put(string, 2);  
	                 continue;  
	             }  
	             diffList.add(string);  
	         }  
	         for(Map.Entry<String, Integer> entry:map.entrySet())  
	         {  
	             if(entry.getValue()==1)  
	             {  
	            	 diffList.add(entry.getKey());  
	             }  
	         }  
	        return diffList;  
	          
	    }  
	 public  List<String> searchRepeatList(List<String> list1, List<String> list2) {  
         List<String> RepeatList = new ArrayList<String>();  
         List<String> maxList = list1;  
         List<String> minList = list2;  
         if(list2.size()>list1.size())  
         {  
             maxList = list2;  
             minList = list1;  
         }  
         Map<String,Integer> map = new HashMap<String,Integer>(maxList.size());  
         for (String string : maxList) {  
             map.put(string, 1);  
         }  
         for (String string : minList) {  
             if(map.get(string)!=null)  
             {  
                 map.put(string, 2);  
                 continue;  
             }  
             RepeatList.add(string);  
         }  
         for(Map.Entry<String, Integer> entry:map.entrySet())  
         {  
             if(entry.getValue()==2)  
             {  
            	 RepeatList.add(entry.getKey());  
             }  
         }  
        return RepeatList;  
          
    }  
}
