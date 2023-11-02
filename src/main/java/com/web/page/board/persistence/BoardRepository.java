package com.web.page.board.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.page.board.domain.Board;


public interface BoardRepository extends JpaRepository<Board, Integer> {

}
