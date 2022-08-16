package com.ktds.metadx.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ktds.metadx.board.dto.FileDTO;

public interface FileMapper {

    int insertFile(@Param("fname")String fileName, 
                @Param("fkey")String fkey,
                @Param("fuuid")String fuuid,
                @Param("fdatatype")String fdatatype,
                @Param("bno")Long bno
                );
                
    List<FileDTO> getFileList(Long bno);
    
}
