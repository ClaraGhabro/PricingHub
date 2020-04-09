package com.pricinghub.recrutement.data;

import com.pricinghub.recrutement.model.Competitor;
import java.util.List;

public interface CompetitorData {
    public List<Competitor> findAll();

    public List<String> findAllCompetitorNames();

    public List<Competitor> findByName(List<String> name);

    public List<Competitor> findByNameAndDates(List<String> name, String startDate, String endDate);

}