package com.pricinghub.recrutement.web.controller;

import com.pricinghub.recrutement.data.CompetitorDataImpl;
import com.pricinghub.recrutement.model.Competitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController("/competitors")
@Controller
public class CompetitorController {

    @Autowired
    private CompetitorDataImpl competitorData;

    // Recuperer la liste de tous les competitors et de leurs attriuts
    @GetMapping(value = "/competitors")
    public List<Competitor> listCompetitorsAndAttributes() {
        return competitorData.findAll();
    }

    // Recuperer la liste des noms des competitors
    @GetMapping(value="/competitors/names")
    public List<String> listCompetitors() {
        return competitorData.findAllCompetitorNames();
    }

    // Recuperer les competitors selon les filtres
    @PostMapping(value = "/competitors/filtered")
    public List<Competitor> filterCompetitors(@RequestParam List<String> names, @RequestParam String startDate, @RequestParam String endDate) {
        return competitorData.addRenderedCompetitors(names, startDate, endDate);
    }

    // Afficher les competitors et leur information selon certains filtres
    @GetMapping(value = "/competitors/filtered")
    public List<Competitor> displayFilteredCompetitor() {
        return competitorData.getRenderedCompetitors();
    }
}
