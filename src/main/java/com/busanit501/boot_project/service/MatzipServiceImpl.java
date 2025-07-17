package com.busanit501.boot_project.service;

import com.busanit501.boot_project.domain.Matzip;
import com.busanit501.boot_project.dto.PageRequestDTO;
import com.busanit501.boot_project.dto.PageResponseDTO;
import com.busanit501.boot_project.dto.matzip.MatzipDTO;
import com.busanit501.boot_project.repository.MatzipRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class MatzipServiceImpl implements MatzipService {

    private final MatzipRepository matzipRepository;

    @Override
    public PageResponseDTO<MatzipDTO> getMatzipList(PageRequestDTO pageRequestDTO) {
        Pageable pageable = PageRequest.of(
                pageRequestDTO.getPage() - 1, // 페이지 번호는 0부터 시작
                pageRequestDTO.getSize(),
                Sort.by("ucSeq").descending() // 일련번호 기준으로 내림차순 정렬
        );

        Page<Matzip> result;

        String type = pageRequestDTO.getType();
        String keyword = pageRequestDTO.getKeyword();

        if (type != null && keyword != null && !keyword.trim().isEmpty()) {
            switch (type) {
                case "t": // 상호명
                    result = matzipRepository.findByMainTitleContaining(keyword, pageable);
                    break;
                case "a": // 주소
                    result = matzipRepository.findByAddr1Containing(keyword, pageable);
                    break;
                case "c": // 설명
                    result = matzipRepository.findByItemcntntsContaining(keyword, pageable);
                    break;
                default:
                    result = matzipRepository.findAll(pageable);
                    break;
            }
        } else {
            result = matzipRepository.findAll(pageable);
        }

        List<MatzipDTO> dtoList = result.getContent().stream()
                .map(matzip -> MatzipDTO.builder()
                        .ucSeq(matzip.getUcSeq())
                        .mainTitle(matzip.getMainTitle())
                        .addr1(matzip.getAddr1())
                        .cntctTel(matzip.getCntctTel())
                        .itemCntnts(matzip.getItemcntnts())
                        .usageDay(matzip.getUsageDay())
                        .mainImgN(matzip.getMainImgN())
                        .mainImgT(matzip.getMainImgT())
                        .course(matzip.getCourse())
                        .gugan(matzip.getGugan())
                        .lat(matzip.getLat())
                        .lng(matzip.getLng())
                        .build())
                .collect(Collectors.toList());

        return PageResponseDTO.<MatzipDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total((int) result.getTotalElements())
                .build();
    }
}
