package com.kuleuven.android.kuleuvenlibrary.submittedQuestionnaireClasses;

import java.util.ArrayList;

/**
 * SubmittedQuestionnaireQuestion
 */

public class SubmittedQuestionnaireQuestion {
    private int id;
    private String question;
    private int bulletType;
    private int conditional;
    private int answersCount;
    private ArrayList<SubmittedQuestionnaireAnswer> answersList;


    /**
     * Public constructor SubmittedQuestionnaireQuestion without condition
     */
    public SubmittedQuestionnaireQuestion(int id, String question, int bulletType, int conditional, int answersCount, ArrayList<SubmittedQuestionnaireAnswer> answersList){
        this.id = id;
        this.question = question;
        this.bulletType = bulletType;
        this.conditional = conditional;
        this.answersCount = answersCount;
        this.answersList = answersList;
    }

    /**
     * Public constructor SubmittedQuestionnaireQuestion without condition
     */
    public SubmittedQuestionnaireQuestion(int id, String question, int bulletType, int conditional, ArrayList<SubmittedQuestionnaireAnswer> answersList){
        this.id = id;
        this.question = question;
        this.bulletType = bulletType;
        this.conditional = conditional;
        this.answersList = answersList;
    }


    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public int getAnswersCount() {
        return answersCount;
    }

    public ArrayList<SubmittedQuestionnaireAnswer> getAnswersList() {
        return answersList;
    }

    public int getBulletType() {
        return bulletType;
    }
}
