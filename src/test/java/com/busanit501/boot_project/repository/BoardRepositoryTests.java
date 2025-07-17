package com.busanit501.boot_project.repository;

import com.busanit501.boot_project.domain.Board;
import com.busanit501.boot_project.domain.BoardImage;
import com.busanit501.boot_project.dto.BoardListReplyCountDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {
    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void testInsert() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Board board = Board.builder()
                    .title("title____" + i)
                    .content("content____" + i)
                    .writer("user_____" + (i % 10))
                    .build();
            Board result = boardRepository.save(board);
            log.info("bno : " + result.getBno());
        });
    }

    @Test
    public void testSelect() {
        Long tno = 100L;
        Optional<Board> result = boardRepository.findById(tno);
        Board board = result.orElseThrow();
        log.info("bno : " + board);
    }

    @Test
    public void testUpdate() {
        Long bno = 100L;
        Optional<Board> result = boardRepository.findById(bno);
        Board board = result.orElseThrow();
        board.changTitleContent("수정제목","수정, 오늘 점심 뭐 먹지?");
        boardRepository.save(board);

    } 

    @Test
    public void testDelete() {
        Long bno = 1L;
        boardRepository.deleteById(bno);
    }

    @Test
    public void testPage() {
        Pageable pageable = PageRequest.of(0,10, Sort.by("bno").descending());
        Page<Board> result = boardRepository.findAll(pageable);
        log.info("전체 갯수 : total count : " + result.getTotalElements());
        log.info("전체 페이지 : total pages : " + result.getTotalPages());
        log.info("현재 페이지 번호 : page number  : " + result.getNumber());
        log.info("보여줄 사이즈 크기 : page size  : " + result.getSize());
        List<Board> todoList = result.getContent();
        log.info("디비에서 페이징된 조회될 데이터 10개 : todoList  : ");
        todoList.forEach(board -> log.info(board));

    } 

    @Test
    public void testSearch() {
        Pageable pageable = PageRequest.of(0,10, Sort.by("bno").descending());
        boardRepository.search(pageable);
    }

    @Test
    public void testSearchAll() {
        String[] types = {"t","c","w"};
        String keyword = "ㅇ";
        Pageable pageable = PageRequest.of(0,10, Sort.by("bno").descending());
        Page<Board> result = boardRepository.searchAll(types, keyword, pageable);
        log.info("전체 갯수 : total count : " + result.getTotalElements());
        log.info("전체 페이지 : total pages : " + result.getTotalPages());
        log.info("현재 페이지 번호 : page number  : " + result.getNumber());
        log.info("보여줄 사이즈 크기 : page size  : " + result.getSize());
        log.info("이전 페이지 유무 : " + result.hasPrevious());
        log.info("다음 페이지 유무 : " + result.hasNext());
        List<Board> todoList = result.getContent();
        log.info("디비에서 페이징된 조회될 데이터 10개 : todoList  : ");
        todoList.forEach(board -> log.info(board));
    }

    @Test
    public void testSearchReplyCount() {
        String[] types = {"t","c","w"};
        String keyword = "ㅇ";
        Pageable pageable = PageRequest.of(0,10, Sort.by("bno").descending());

        Page<BoardListReplyCountDTO> result = boardRepository.searchWithReplyCount(types, keyword, pageable);
        log.info("전체 갯수 : total count : " + result.getTotalElements());
        log.info("전체 페이지 : total pages : " + result.getTotalPages());
        log.info("현재 페이지 번호 : page number  : " + result.getNumber());
        log.info("보여줄 사이즈 크기 : page size  : " + result.getSize());
        log.info("이전 페이지 유무 : " + result.hasPrevious());
        log.info("다음 페이지 유무 : " + result.hasNext());
        List<BoardListReplyCountDTO> todoList = result.getContent();
        log.info("디비에서 페이징된 조회될 데이터 10개 : todoList  : ");
        todoList.forEach(board -> log.info(board));
    }

    @Test
    public void testInsertWithImages() {
        Board board = Board.builder()
                .title("첨부 이미지 추가한 게시글 테스트")
                .content("첨부 파일 추가해서 게시글 작성 테스트")
                .writer("이상용")
                .build();
        for(int i = 0; i < 3; i++) {
            board.addImage(UUID.randomUUID().toString(),"file"+i+".jpg");
        }
        boardRepository.save(board);
    }

    @Test
    @Transactional
    public void testReadWithImages() {
        Optional<Board> result = boardRepository.findByIdWithImages(113L);
        Board board = result.orElseThrow();
        log.info("testReadWithImages에서 : 확인 board " + board);
        for(BoardImage boardImage : board.getImageSet()) {
            log.info("첨부 이미지 확인 :  "+boardImage);
        }
    }

    @Test
    @Transactional
    @Commit
    public void testModifyImages() {
       Optional<Board> result =  boardRepository.findByIdWithImages(113L);
       Board board = result.orElseThrow();

        board.clearImages();

        for(int i = 0; i < 3; i++) {
            board.addImage(UUID.randomUUID().toString(),"Update-file-2"+i+".jpg");
        }
        boardRepository.save(board);

    }

    @Test
    @Transactional
    @Commit
    public void testRemoveAll() {
        replyRepository.deleteByBoard_Bno(113L);
        boardRepository.deleteById(113L);
    }

}