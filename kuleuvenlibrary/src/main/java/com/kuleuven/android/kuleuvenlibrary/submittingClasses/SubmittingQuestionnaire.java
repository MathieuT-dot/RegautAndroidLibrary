package com.kuleuven.android.kuleuvenlibrary.submittingClasses;

import java.util.ArrayList;

/**
 * SubmittingQuestionnaire
 */

public class SubmittingQuestionnaire {

    private int id;
    private String title;
    private int questionsCount;
    private ArrayList<SubmittingQuestion> submittingQuestionsList;
    private int editId;
    private long startMillis = 0;
    private long stopMillis = 0;

    private int forUserId;
    private boolean forUserIdChanged = false;
    private String forUserName = "";
    private int byUserId;
    private int previousSubmissionId;


    public SubmittingQuestionnaire(int id, int questionsCount, ArrayList<SubmittingQuestion> submittingQuestionsList, String title, int editId) {
        this.id = id;
        this.questionsCount = questionsCount;
        this.submittingQuestionsList = submittingQuestionsList;
        this.title = title;
        this.editId = editId;
    }

    public SubmittingQuestionnaire(int id, int questionsCount, ArrayList<SubmittingQuestion> submittingQuestionsList, String title, int previousSubmissionId, int forUserId, int byUserId) {
        this.id = id;
        this.questionsCount = questionsCount;
        this.submittingQuestionsList = submittingQuestionsList;
        this.title = title;
        this.previousSubmissionId = previousSubmissionId;
        this.forUserId = forUserId;
        this.byUserId = byUserId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getQuestionsCount() {
        return questionsCount;
    }

    public ArrayList<SubmittingQuestion> getSubmittingQuestionsList() {
        return submittingQuestionsList;
    }

    public int getEditId() {
        return editId;
    }

    public long getStartMillis() {
        return startMillis;
    }

    public void setStartMillis(long startMillis) {
        this.startMillis = startMillis;
    }

    public long getStopMillis() {
        return stopMillis;
    }

    public void setStopMillis(long stopMillis) {
        this.stopMillis = stopMillis;
    }

    public int getForUserId() {
        return forUserId;
    }

    public void setForUserId(int forUserId) {
        this.forUserId = forUserId;
    }

    public boolean isForUserIdChanged() {
        return forUserIdChanged;
    }

    public void setForUserIdChanged(boolean forUserIdChanged) {
        this.forUserIdChanged = forUserIdChanged;
    }

    public int getByUserId() {
        return byUserId;
    }

    public void setByUserId(int byUserId) {
        this.byUserId = byUserId;
    }

    public int getPreviousSubmissionId() {
        return previousSubmissionId;
    }

    public void setPreviousSubmissionId(int previousSubmissionId) {
        this.previousSubmissionId = previousSubmissionId;
    }

    public String getForUserName() {
        return forUserName;
    }

    public void setForUserName(String forUserName) {
        this.forUserName = forUserName;
    }
}
