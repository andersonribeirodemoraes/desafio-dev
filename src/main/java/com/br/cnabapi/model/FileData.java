package com.br.cnabapi.model;

import lombok.Data;

@Data
public class FileData {

    private String filename;
    private String url;
    private Long size;    
}
