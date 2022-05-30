package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Benzyl {
    private Pattern pattern = Pattern.compile("^benzyl");


    public boolean assertRegex(String input){
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()){
            return true;
        } else {
            return  false;
        }
    }
}
