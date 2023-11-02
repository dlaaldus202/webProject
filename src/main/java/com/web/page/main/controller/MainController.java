package com.web.page.main.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.web.page.board.domain.Board;
import com.web.page.board.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {

	//Path지정 
	private static final String FOLER_PATH = "/Page/Main/";
	
	
	//목록
	@RequestMapping("")
	public String list(Model model) {
	
		return FOLER_PATH+"index";
	}
	
	/*
	// 글 등록 처리
	@PostMapping("/insertBoard")
	public String insertBoard(Board board, @RequestBody MultipartFile uploadFile) throws Exception {
		// 파일 업로드 처리
		if(!uploadFile.isEmpty()) {
			uploadFile.transferTo(new File("C:/DEV/upload_files/" + uploadFile.getOriginalFilename()));
		}
		
		// 글 등록 처리
		boardService.insertBoard(board);
		// 리턴되는 View이름 앞에 "forward:"이나 "redirect:"을 붙이면 ViewResovler가 동작하지 않는다.
		return "redirect:getBoardList";
	}
	
	// 글 수정 처리
	@PostMapping("/updateBoard")
	// 세션에 "board"라는 이름으로 등록된 객체를 우선 적용한다.
	public String updateBoard(@ModelAttribute("board") Board board) {
		boardService.updateBoard(board);
		return "forward:getBoardList";
	}
	
	// 글 삭제 처리
	@GetMapping("/deleteBoard")
	public String deleteBoard(Board board) {
		boardService.deleteBoard(board);
		return "forward:getBoardList";
	}
	
	// 글 상세 조회
	@GetMapping("/getBoard")
	public String getBoard(Board board, Model model) {
		model.addAttribute("board", boardService.getBoard(board));
		return "getBoard";
	}
	
	// 글 목록 검색
	
	@RequestMapping("/getBoardList")
	public String getBoardList(Board board, Model model) {
		// Model 객체에 검색 결과를 등록해야 JSP화면에서 사용할 수 있다.
		model.addAttribute("boardList", boardService.getBoardList(board));
		
		// Controller가 문자열을 리턴하면 ViewResovler가 접두사, 접미사를 붙여준다. 
		return "getBoardList";
	}
	*/
	
	
}









