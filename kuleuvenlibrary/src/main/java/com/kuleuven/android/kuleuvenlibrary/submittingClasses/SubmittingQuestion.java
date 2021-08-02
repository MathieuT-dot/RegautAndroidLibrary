package com.kuleuven.android.kuleuvenlibrary.submittingClasses;

import java.util.ArrayList;

/**
 * SubmittingQuestion
 * 
 * Class to hold the info about a Question of a Questionnaire to be submitted
 */
public class SubmittingQuestion {

    private int id;
    private ArrayList<SubmittingAnswer> submittingAnswerList = new ArrayList<>();


    public SubmittingQuestion(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public ArrayList<SubmittingAnswer> getSubmittingAnswerList() {
        return submittingAnswerList;
    }

    public void setSubmittingAnswerList(ArrayList<SubmittingAnswer> submittingAnswerList) {
        this.submittingAnswerList.clear();
        this.submittingAnswerList = submittingAnswerList;
    }
}
