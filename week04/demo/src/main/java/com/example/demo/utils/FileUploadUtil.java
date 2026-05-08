package com.example.demo.utils;

import com.example.demo.handler.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.UUID;


@Slf4j
public class FileUploadUtil {

    private static final String UPLOAD_DIR;

    /**
     * 允许上传的文件类型白名单
     */
    private static final Set<String> ALLOWED_EXTENSIONS = Set.of(
            ".jpg", ".jpeg", ".png", ".gif", ".bmp", ".webp",
            ".pdf", ".doc", ".docx", ".xls", ".xlsx", ".ppt", ".pptx",
            ".txt", ".md", ".csv",
            ".zip", ".rar", ".7z",
            ".json", ".xml"
    );

    static {
        UPLOAD_DIR = initUploadDir();
        createUploadDirectory();
    }

    /**
     * 初始化上传目录
     */
    private static String initUploadDir() {
        try {
            // 获取项目根目录
            String baseDir = ResourceUtils.getURL("classpath:").getPath();
            // 创建上传目录
            Path uploadPath = Paths.get(baseDir, "static/upload/");
            Files.createDirectories(uploadPath);
            String uploadDir = uploadPath.toAbsolutePath().toString() + File.separator;
            log.info("上传目录: {}", uploadDir);
            return uploadDir;
        } catch (IOException e) {
            throw new RuntimeException("创建上传目录失败", e);
        }
    }

    /**
     * 创建上传目录（如果不存在）
     */
    private static void createUploadDirectory() {
        File dir = new File(UPLOAD_DIR);
        if (!dir.exists()) {
            if (!dir.mkdirs()) {
                throw new RuntimeException("创建上传目录失败: " + UPLOAD_DIR);
            }
        }
    }

    /**
     * 获取上传目录（API端点）
     */
    @GetMapping("/upload")
    public String getUploadDir() {
        return UPLOAD_DIR;
    }

    /**
     * 文件上传
     */
    @PostMapping("/upload")
    public static String upload(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null || originalFilename.isEmpty()) {
            throw new BusinessException(400, "文件名不能为空");
        }

        // 获取文件后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
        // 文件类型校验
        if (!ALLOWED_EXTENSIONS.contains(suffix)) {
            throw new BusinessException(400, "不支持的文件类型: " + suffix);
        }

        // 拼接新文件名，并创建新文件
        String fileName = UUID.randomUUID().toString() + suffix;
        File dest = new File(UPLOAD_DIR + fileName);
        // 保存新文件到上传目录（上传）
        file.transferTo(dest);

        log.info("文件上传成功: {} -> {}", originalFilename, fileName);
        return fileName;
    }
}
