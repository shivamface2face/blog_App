package com.blogApp.Services.impl;

import com.blogApp.Services.FileService;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileServiceImpl implements FileService {
    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
        return "";
    }

    @Override
    public InputStream getResource(String path, String fileName) throws FileNotFoundException {
        return null;
    }
}
