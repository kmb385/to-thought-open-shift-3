package com.rhcloud.tothought.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rhcloud.tothought.data.entities.Degree;

public interface DegreeRepository extends JpaRepository<Degree, Integer> {

}
