package com.talissonmelo.osworks.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.talissonmelo.osworks.domain.model.Comments;

public interface CommentsRepository extends JpaRepository<Comments, Long> {

}
