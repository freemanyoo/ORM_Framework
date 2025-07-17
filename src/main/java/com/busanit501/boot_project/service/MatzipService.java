package com.busanit501.boot_project.service;

import com.busanit501.boot_project.dto.PageRequestDTO;
import com.busanit501.boot_project.dto.PageResponseDTO;
import com.busanit501.boot_project.dto.matzip.MatzipResponseDTO;

public interface MatzipService {
    PageResponseDTO<MatzipResponseDTO.Item> getMatzipList(PageRequestDTO pageRequestDTO);
}