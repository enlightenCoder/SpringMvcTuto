package com.nit.MVCProj2DataRendering.service;


import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service("seasonService")
public class SeaonFinderServiceImpl implements ISeasonFinderService {
    @Override
    public String findSeason() {

        LocalDate ld = LocalDate.now();
        // find current month
        int month = ld.getMonthValue();
        // find season
        if(month>=7 && month<=9)
            return "Rainy Season";
        else if(month>=3 && month<=6)
            return "Summer Season";
        else
            return "Winter Season";
    }
}
