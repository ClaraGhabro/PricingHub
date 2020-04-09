package com.pricinghub.recrutement.data;

import com.opencsv.CSVReader;
import com.pricinghub.recrutement.model.Competitor;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Repository
public class CompetitorDataImpl implements CompetitorData {
    public static List<Competitor> competitors = new ArrayList();
    private List<Competitor> renderedCompetitors = new ArrayList<>();

    static {
        CSVReader reader = null;

        try {
            String filePath = System.getProperty("user.dir") + "/data.csv";
            reader = new CSVReader(new FileReader(filePath), ',', '\'', 1);
            String[] line;
            while ((line = reader.readNext()) != null)
                competitors.add(new Competitor(line));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public List<Competitor> findAll() {
        HashSet<Competitor> distinctCompetitors = new HashSet<>();
        for (Competitor c: competitors)
            distinctCompetitors.add(c);
        return new ArrayList<>(distinctCompetitors);
    }

    public List<String> findAllCompetitorNames() {
        HashSet<String> names = new HashSet();

        for (Competitor c: competitors)
            names.add(c.getName());

        return new ArrayList<>(names);
    }

    public Competitor findByName(String name) {
        for (Competitor c: competitors)
            if (c.getName().equals(name))
                return c;

        return null;
    }

    public List<Competitor> findByName(List<String> names) {
        List<Competitor> compets = new ArrayList();
        for (String name: names) {
            System.out.println("on cherche ce name: " + name);
            for (Competitor c : competitors) {
                if (c.getName().equals(name)) {
                    compets.add(c);
                    break;
                }
            }
        }

        return compets;
    }

    public List<Competitor> findByNameAndDates(List<String> names, String startDate, String endDate) {

        List<Competitor> compets = new ArrayList<>();
        try {
            Date start = new SimpleDateFormat("dd/MM/yyyy").parse(startDate);
            Date end = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
            for (String name: names)
                for (Competitor c: competitors)
                    if (c.getName().equals(name) && c.getDay().compareTo(start) >= 0  && c.getDay().compareTo(end) <= 0)
                        compets.add(c);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("taille du truc: " + compets.size());
            return compets;
        }
    }

    public void clearRenderedCompetitors() {
        renderedCompetitors.clear();
    }

    public List<Competitor> addRenderedCompetitors(List<String> names, String startDate, String endDate) {
        renderedCompetitors = findByNameAndDates(names, startDate, endDate);
        return renderedCompetitors;
    }

    public List<Competitor> getRenderedCompetitors() {
        return renderedCompetitors;
    }
}
