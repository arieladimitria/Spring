package com.meublog.blogariela.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meublog.blogariela.model.Postagens;

@Repository
public interface PostagensRepository extends JpaRepository<Postagens, Long> {
	
	public List<Postagens> findAllByTituloContainingIgnoreCase (String titulo); 

}
