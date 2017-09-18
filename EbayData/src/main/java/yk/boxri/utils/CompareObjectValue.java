package yk.boxri.utils;

import java.lang.reflect.Field;

public class CompareObjectValue {
	public boolean compareObjectValue(Object class1,Object class2) throws IllegalArgumentException, IllegalAccessException{
		 
		boolean flag=false;
		//��ȡ�����class  
		    Class<?> clazz1 = class1.getClass();  
		    Class<?> clazz2 = class2.getClass();  
		//��ȡ����������б�  
		    Field[] field1 = clazz1.getDeclaredFields();  
		    Field[] field2 = clazz2.getDeclaredFields();  
		//���������б�field1 
		    label:
		    for(int i=0;i<field1.length;i++){  
		//���������б�field2
		        for(int j=0;j<field2.length;j++){  
		//���field1[i]��������field2[j]������������ͬ   
		        	if(field1[i].getName().equals(field2[j].getName())){
		                field1[i].setAccessible(true);  
		                field2[j].setAccessible(true);  
		//���field1[i]����ֵ��field2[j]����ֵ���ݲ���ͬ  
		                if("serialVersionUID".equals(field1[i].getName())){//�Զ���ɵ�ֵ,���Ž��
		                	break;
		                }else if (compareTwo(field1[i].get(class1), field2[j].get(class2))){  
		                	flag=true;
		                	break;
		               }else if(!compareTwo(field1[i].get(class1), field2[j].get(class2))){
		            	   flag=false;
		            	   break label;
		               }
		                 
		           }  
		        }
		     }  
			return flag;
	}
    /**  
     * �Ա���������Ƿ�������ͬ  
     *  
     * @param  object1,object2  
     * @return boolean����  
     */  
    public boolean compareTwo(Object object1,Object object2){  
      
        if(object1==null&&object2==null){  
            return true;  
        }  
        if(object1==null&&object2!=null){  
            return false;  
        }  
        if(object1.equals(object2)){  
            return true;  
        }  
        return false;  
    }  
}
