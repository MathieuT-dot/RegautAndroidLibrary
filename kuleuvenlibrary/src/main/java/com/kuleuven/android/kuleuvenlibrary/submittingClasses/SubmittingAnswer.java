package com.kuleuven.android.kuleuvenlibrary.submittingClasses;

/**
 * SubmittingAnswer
 * 
 * Class to hold the info about an Answer of a Question of a Questionnaire to be submitted
 */
public class SubmittingAnswer {

    private int id;
    private int typeId;
    // Fixed = 0 / Integer = 1 / Double = 2 / String = 3
    private int answerType;
    private int intValue;
    private Double doubleValue;
    private String stringValue;


    public SubmittingAnswer(int id, int typeId){
        this.id = id;
        this.typeId = typeId;
        this.answerType = 0;
    }

    public SubmittingAnswer(int id, int typeId, int intValue){
        this.id = id;
        this.typeId = typeId;
        this.answerType = 1;
        this.intValue = intValue;
    }

    public SubmittingAnswer(int id, int typeId, Double doubleValue){
        this.id = id;
        this.typeId = typeId;
        this.answerType = 2;
        this.doubleValue = doubleValue;
    }

    public SubmittingAnswer(int id, int typeId, String stringValue){
        this.id = id;
        this.typeId = typeId;
        this.answerType = 3;
        this.stringValue = stringValue;
    }


    public int getId() {
        return id;
    }

    public int getTypeId() {
        return typeId;
    }

    public int getAnswerType() {
        return answerType;
    }

    public int getIntValue() {
        return intValue;
    }

    public Double getDoubleValue() {
        return doubleValue;
    }

    public String getStringValue() {
        return stringValue;
    }

}
