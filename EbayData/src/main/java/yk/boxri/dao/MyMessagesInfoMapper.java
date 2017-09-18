package yk.boxri.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import yk.boxri.pojo.MyMessagesInfo;

public interface MyMessagesInfoMapper {
	
    int deleteByPrimaryKey(String message_id);

    int insert(MyMessagesInfo record);

    MyMessagesInfo selectByPrimaryKey(String message_id);

    List<MyMessagesInfo> selectAll();
    
    List<String> dynamicSelectId(List<String> messageId);

    List<MyMessagesInfo> dynamicSelect(List<String> messageId);
    
    int updateByPrimaryKey(MyMessagesInfo record);

    int batchUpdate(List<MyMessagesInfo> recordLst);
    
    void insertBatch(List<MyMessagesInfo> recordLst);
}