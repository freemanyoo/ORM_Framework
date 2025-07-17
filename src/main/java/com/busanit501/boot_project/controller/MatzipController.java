package com.busanit501.boot_project.controller;

import com.busanit501.boot_project.dto.PageRequestDTO;
import com.busanit501.boot_project.dto.PageResponseDTO;
import com.busanit501.boot_project.dto.matzip.MatzipResponseDTO;
import com.busanit501.boot_project.service.MatzipService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/matzip")
@Log4j2
@RequiredArgsConstructor
public class MatzipController {

    private final MatzipService matzipService;

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model) {
        log.info("matzip list................" + pageRequestDTO);

        PageResponseDTO<MatzipResponseDTO.Item> responseDTO = matzipService.getMatzipList(pageRequestDTO);

        model.addAttribute("responseDTO", responseDTO);
    }
}