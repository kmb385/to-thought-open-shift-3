package com.rhcloud.tothought.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rhcloud.tothought.data.entities.Image;

public interface ImageRepository extends JpaRepository<Image, Integer> {

}
