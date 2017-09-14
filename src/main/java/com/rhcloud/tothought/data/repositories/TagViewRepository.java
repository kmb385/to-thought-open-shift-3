package com.rhcloud.tothought.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rhcloud.tothought.data.views.TagView;


public interface TagViewRepository extends JpaRepository<TagView, Integer> {

}
