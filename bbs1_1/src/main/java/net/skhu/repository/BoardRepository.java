package net.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {

}
