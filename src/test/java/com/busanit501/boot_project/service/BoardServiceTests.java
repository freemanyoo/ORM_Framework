package com.busanit501.boot_project.service;

import com.busanit501.boot_project.dto.BoardDTO;
import com.busanit501.boot_project.dto.BoardListReplyCountDTO;
import com.busanit501.boot_project.dto.PageRequestDTO;
import com.busanit501.boot_project.dto.PageResponseDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class BoardServiceTests {

    @Autowired
    private BoardService boardService;

    @Test
    public void testRegister() {
        BoardDTO boardDTO = BoardDTO.builder()
                .title("서비스 작업 단위 테스트 중")
                .content("서비스 작업 단위 테스트 내용 작성중 ")
                .writer("이상용")
                .build();
        boardService.register(boardDTO);
    }

    @Test
    public void testReadOne() {
        BoardDTO boardDTO = boardService.readOne(102L);
        log.info("서비스 단위테스트에서 하나 조회 boardDTO : " + boardDTO);
    }

    @Test
    public void testModify() {
        BoardDTO boardDTO = boardService.readOne(102L);
        boardDTO.setTitle("수정2 테스트 ");
        boardDTO.setContent("오늘 점심 뭐 먹지 ??");

        boardService.modify(boardDTO);
    }

    @Test
    public void testDelete() {
        boardService.remove(102L);
    }

    @Test
    public void testList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .type("tcw")
                .keyword("1")
                .page(1)
                .size(10)
                .build();

        PageResponseDTO<BoardDTO> responseDTO = boardService.list(pageRequestDTO);
        log.info("서비스 테스트 작업 중, responseDTO : " + responseDTO);
    }

    @Test
    public void testSearchWithReplyCount() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .type("tcw")
                .keyword("ㅇ")
                .page(1)
                .size(10)
                .build();

        PageResponseDTO<BoardListReplyCountDTO> responseDTO = boardService.listWithReplyCount(pageRequestDTO);
        log.info("서비스 테스트 작업 중2, responseDTO : " + responseDTO);

    }

}