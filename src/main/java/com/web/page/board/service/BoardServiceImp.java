package com.web.page.board.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.page.board.domain.Board;
import com.web.page.board.persistence.BoardRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImp implements BoardService{
	@Autowired
	private BoardRepository boardRepository;
	
	// 글 등록
	public void insertBoard(Board board) {
		boardRepository.save(board);
	}
	
	// 글 수정
	public void updateBoard(Board board) {
		boardRepository.save(board);
	}
	
	// 글 삭제
	public void deleteBoard(Board board) {
		boardRepository.deleteById(board.getSeq());
	}
	
	// 글 상세 조회
	public Optional<Board> getBoard(Board board) {
		return boardRepository.findById(board.getSeq());
	}
	
	// 글 목록 검색
	public List<Board> getBoardList(Board board) {
		return boardRepository.findAll();
	}
	

}
