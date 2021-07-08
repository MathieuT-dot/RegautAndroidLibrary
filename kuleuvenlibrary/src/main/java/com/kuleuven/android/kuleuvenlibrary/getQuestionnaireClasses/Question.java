package com.kuleuven.android.kuleuvenlibrary.getQuestionnaireClasses;

import java.util.ArrayList;

/**
 * Question
 */

public class Question {

    private int id;
    private String question;
    private String tooltip;
    private int bulletType;
    private int conditional;
    private int answersCount;
    private ArrayList<Answer> answersList;
    private int conditionQuestionId;
    private int conditionAnswerId;

    public static final int NO_BULLETS = 1; // Fixed
    public static final int RADIO_BUTTONS = 2; // Integer
    public static final int CHECKBOXES = 3; // Double
    public static final int BODY_CHART = 4; // Scale

    /**
     * Public constructor Question without condition
     */
    public Question(int id, String question, String tooltip, int bulletType, int conditional, int answerCount, ArrayList<Answer> answersList){
        this.id = id;
        this.question = question;
        this.tooltip = tooltip;
        this.bulletType = bulletType;
        this.conditional = conditional;
        this.answersCount = answerCount;
        this.answersList = answersList;
        this.conditionQuestionId = -1;
        this.conditionAnswerId = -1;
    }

    /**
     * Public constructor Question with condition
     */
    public Question(int id, String question, String tooltip, int bulletType, int conditional, int answerCount, ArrayList<Answer> answersList, int conditionQuestionId, int conditionAnswerId){
        this.id = id;
        this.question = question;
        this.tooltip = tooltip;
        this.bulletType = bulletType;
        this.conditional = conditional;
        this.answersCount = answerCount;
        this.answersList = answersList;
        this.conditionQuestionId = conditionQuestionId;
        this.conditionAnswerId = conditionAnswerId;
    }

    /**
     * Public constructor Question without condition
     */
    public Question(int id, String question, String tooltip, int bulletType, int conditional, ArrayList<Answer> answersList){
        this.id = id;
        this.question = question;
        this.tooltip = tooltip;
        this.bulletType = bulletType;
        this.conditional = conditional;
        this.answersList = answersList;
        this.conditionQuestionId = -1;
        this.conditionAnswerId = -1;
    }

    /**
     * Public constructor Question with condition
     */
    public Question(int id, String question, String tooltip, int bulletType, int conditional, ArrayList<Answer> answersList, int conditionQuestionId, int conditionAnswerId){
        this.id = id;
        this.question = question;
        this.tooltip = tooltip;
        this.bulletType = bulletType;
        this.conditional = conditional;
        this.answersList = answersList;
        this.conditionQuestionId = conditionQuestionId;
        this.conditionAnswerId = conditionAnswerId;
    }


    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getTooltip() {
        return tooltip;
    }

    public int getBulletType() {
        return bulletType;
    }

    public int getConditional() {
        return conditional;
    }

    public ArrayList<Answer> getAnswersList() {
        return answersList;
    }

    public int getConditionQuestionId() {
        return conditionQuestionId;
    }

    public int getConditionAnswerId() {
        return conditionAnswerId;
    }

}
