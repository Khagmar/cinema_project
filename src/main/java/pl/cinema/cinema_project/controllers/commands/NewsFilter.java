package pl.cinema.cinema_project.controllers.commands;

import org.thymeleaf.util.StringUtils;

public class NewsFilter {
    private  String phrase;

    public  boolean isEmpty()
    {
        return StringUtils.isEmpty(phrase);
    }

    public void clear() {
        this.phrase = "";
    }

    public String getPhraseLIKE() {
        if (StringUtils.isEmpty(phrase)) {
            return null;
        } else {
            return "%" + phrase + "%";
        }

    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

}
