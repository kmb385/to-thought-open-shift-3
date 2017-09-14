package com.rhcloud.tothought.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rhcloud.tothought.data.entities.DataLoadLogEntry;

public interface DataLoadLogEntryRepository extends JpaRepository<DataLoadLogEntry, Integer> {

}
