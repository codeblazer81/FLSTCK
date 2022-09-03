package com.example.servingwebcontent.mapper;

import com.example.servingwebcontent.model.ChatMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MessageMapper {

    @Select("SELECT * FROM MESSAGES ")
    ChatMessage getMessage();

    @Insert("INSERT INTO MESSAGES (messageText, userName) VALUES(#{messageText},#{username})")
    @Options(useGeneratedKeys = true, keyProperty = "messageId")
    int insert(ChatMessage chatMessage);
    
}
