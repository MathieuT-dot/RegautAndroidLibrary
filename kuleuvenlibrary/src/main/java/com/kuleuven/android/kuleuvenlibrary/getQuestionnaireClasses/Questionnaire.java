package com.kuleuven.android.kuleuvenlibrary.getQuestionnaireClasses;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Questionnaire
 */

public class Questionnaire {

    static final int NONE = 0;
    static final int EDITABLE = 1;
    static final int COPYABLE = 2;

    private int id;
    private int groupId;
    private int version;
    private String title;
    private String description;
    private String language;
    private boolean draft;
    private int editable;
    private int questionsCount;
    private ArrayList<Question> questionsList;


    public Questionnaire(int id, int groupId, int version, String title, String description, boolean draft, int editable, String language, int questionsCount, ArrayList<Question> questionsList){
        this.id = id;
        this.groupId = groupId;
        this.version = version;
        this.title = title;
        this.description = description;
        this.draft = draft;
        this.editable = editable;
        this.language = language;
        this.questionsCount = questionsCount;
        this.questionsList = questionsList;
    }

    public Questionnaire(int id, int groupId, int version, String title, String description, boolean draft, int editable, ArrayList<Question> questionsList){
        this.id = id;
        this.groupId = groupId;
        this.version = version;
        this.title = title;
        this.description = description;
        this.draft = draft;
        this.editable = editable;
        this.questionsList = questionsList;
    }

    public Questionnaire(int id, int groupId, int version, String title, String description, boolean draft, int editable, int questionsCount){
        this.id = id;
        this.groupId = groupId;
        this.version = version;
        this.title = title;
        this.description = description;
        this.language = null;
        this.draft = draft;
        this.editable = editable;
        this.questionsCount = questionsCount;
        this.questionsList = null;
    }

    public Questionnaire(int id, int groupId, int version, String title, String description, boolean draft, int editable){
        this.id = id;
        this.groupId = groupId;
        this.version = version;
        this.title = title;
        this.description = description;
        this.language = null;
        this.draft = draft;
        this.editable = editable;
        this.questionsList = null;
    }


    public int getId() {
        return id;
    }

    public int getGroupId() {
        return groupId;
    }

    public int getVersion() {
        return version;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDraft() {
        return draft;
    }

    public int getEditable() {
        return editable;
    }

    public ArrayList<Question> getQuestionsList() {
        return questionsList;
    }

    public static class IdComparator implements Comparator<Questionnaire> {
        @Override
        public int compare(Questionnaire o1, Questionnaire o2) {
            return Integer.compare(o1.id, o2.id);
        }
    }

    public static class TitleComparator implements Comparator<Questionnaire> {
        @Override
        public int compare(Questionnaire o1, Questionnaire o2) {
            return o1.title.compareTo(o2.title);
        }
    }

}
