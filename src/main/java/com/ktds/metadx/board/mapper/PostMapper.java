package com.ktds.metadx.board.mapper;

import org.apache.ibatis.annotations.Param;

import com.ktds.metadx.board.dto.PostDTO;

// import java.util.List;

// import com.ktds.metadx.board.dto.PostDTO;

public interface PostMapper {
    String fileDataType(PostDTO postDTO);
    
    int insertFile(@Param("fname")String fileName, 
                @Param("fkey")String fkey,
                @Param("fuuid")String fuuid,
                @Param("fileDataType")String fileDataType  
                );
}
