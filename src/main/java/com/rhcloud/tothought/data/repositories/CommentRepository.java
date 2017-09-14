package com.rhcloud.tothought.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rhcloud.tothought.data.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
