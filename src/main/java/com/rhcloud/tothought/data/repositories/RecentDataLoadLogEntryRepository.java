package com.rhcloud.tothought.data.repositories;

import org.springframework.data.repository.Repository;
import com.rhcloud.tothought.data.views.RecentDataLoadLogEntry;

public interface RecentDataLoadLogEntryRepository extends Repository<RecentDataLoadLogEntry, Integer> {

	public RecentDataLoadLogEntry findByLoadName(String loadName);
}
