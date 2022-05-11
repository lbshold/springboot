package com.example.demo.pdf;

import lombok.Data;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * 填充PDF内容，包含文字和图片.
 *
 * @author: liusj
 * @date: 2022/5/11
 */
@Data
public class FillContent {

    private Map<String, String> contentMap;

    private Map<String, List<File>> imageMap;
}
