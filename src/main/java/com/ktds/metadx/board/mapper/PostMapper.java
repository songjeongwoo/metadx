package com.ktds.metadx.board.mapper;

import org.apache.ibatis.annotations.Param;

public interface PostMapper {

    int insertFile(@Param("fname")String fileName, 
                @Param("fkey")String fkey,
                @Param("fuuid")String fuuid,
                @Param("fileDataType")String fileDataType  
                );
}
