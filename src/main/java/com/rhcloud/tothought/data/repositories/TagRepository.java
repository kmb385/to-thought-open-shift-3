package com.rhcloud.tothought.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.rhcloud.tothought.data.entities.Tag;

public interface TagRepository extends JpaRepository<Tag, Integer> {
	
	@Query("select t from Tag t where lower(t.name) like '%' || :name || '%'")
	public List<Tag> findByName(@Param("name") String name);
	
}
