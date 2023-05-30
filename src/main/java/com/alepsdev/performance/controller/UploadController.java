package com.alepsdev.performance.controller;

import com.alepsdev.performance.DataProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

    private final DataProcessor dataProcessor;

    public UploadController(DataProcessor dataProcessor) {
        this.dataProcessor = dataProcessor;
    }

    @GetMapping("/")
    public String showUploadForm() {
        return "uploadForm";
    }

    @PostMapping("/upload")
    public String handleFileUpload(MultipartFile file, Model model) {
        try {
            dataProcessor.processFile(file);
            model.addAttribute("message", "Arquivo processado com sucesso!");
        } catch (Exception e) {
            model.addAttribute("error", "Erro ao processar o arquivo: " + e.getMessage());
        }
        return "uploadForm";
    }
}
