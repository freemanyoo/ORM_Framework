package com.busanit501.boot_project.repository;

import com.busanit501.boot_project.domain.Board;
import com.busanit501.boot_project.domain.Reply;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Log4j2
public class ReplyRepositoryTests {
    @Autowired
    private ReplyRepository replyRepository;
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void testInsert() {
        Long bno = 108L;

        Board board = Board.builder()
                .bno(bno).build();

        Reply reply = Reply.builder()
                .board(board)
                .replyText("샘플 게시글 내용4")
                .replyer("샘플 댓글 작성자4")
                .build();

        replyRepository.save(reply);
    }

    @Test
    @Transactional
    public void testBoardReplies() {
        Long bno = 109L;
        Pageable pageable = PageRequest.of(0, 10, Sort.by("rno").descending());
        Page<Reply> result = replyRepository.listOfBoard(bno, pageable);
        result.getContent().forEach(
                reply -> {
                    log.info("replyRepositoryTests : 조회된 댓글 확인" + reply);
                }
        );

    }

    @Test
    @Transactional
    @Rollback(false)
    public void testInsertMany() {
        Long bno = 108L;
        Board board = boardRepository.findById(bno).orElseThrow();
        List<Reply> replies = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            replies.add(Reply.builder()
                    .board(board)
                    .replyText("더미 댓글 내용 : " + i)
                    .replyer("더미 유저_" + i)
                    .build());
        }
        replyRepository.saveAll(replies);
    }


}