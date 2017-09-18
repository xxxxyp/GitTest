package yk.boxri.utils;

import java.util.List;

public class CompareListObject {
	public List<?> compareListObject(List<?> waitUpdate,List<?> existorder) throws IllegalArgumentException, IllegalAccessException{
		CompareObjectValue compareObjectValue=new CompareObjectValue();
		for(int i=waitUpdate.size()-1;i>=0;i--){
			for(int y=0;y<existorder.size();y++){
				if(compareObjectValue.compareObjectValue(waitUpdate.get(i), existorder.get(y))){
					waitUpdate.remove(i);
					break;
				}
			}
		}
		return waitUpdate;
	
	}

}
