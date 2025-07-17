package com.busanit501.boot_project.service;

import com.busanit501.boot_project.dto.PageRequestDTO;
import com.busanit501.boot_project.dto.PageResponseDTO;
import com.busanit501.boot_project.dto.matzip.MatzipDTO;

public interface MatzipService {
    PageResponseDTO<MatzipDTO> getMatzipList(PageRequestDTO pageRequestDTO);
}
