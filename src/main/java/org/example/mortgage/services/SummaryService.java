package org.example.mortgage.services;

import org.example.mortgage.model.Rate;
import org.example.mortgage.model.Summary;

import java.util.List;

public interface SummaryService {

    Summary calculateSummary(List<Rate> rates);
}
