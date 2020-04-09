package com.pricinghub.recrutement.data;

import com.pricinghub.recrutement.model.Competitor;
import java.util.List;

public interface CompetitorData {
    List<Competitor> findAll();

    List<String> findAllCompetitorNames();

    List<Competitor> findByNameAndDates(List<String> name, String startDate, String endDate);

}