package com.web.page.board.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@Entity 
@Table(name = "BOARD")
public class Board {  
	@Id 				
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seq;
	
	private String title;
	
	@Column(updatable = false)
	private String writer;
	
	private String content;	
	
	@Column(updatable = false)
	private Date regDate = new Date();
	
	@Column(updatable = false)
	private int cnt;

//	// 파일 업로드 관련 변수
//	@Transient
//	private MultipartFile uploadFile;

}







