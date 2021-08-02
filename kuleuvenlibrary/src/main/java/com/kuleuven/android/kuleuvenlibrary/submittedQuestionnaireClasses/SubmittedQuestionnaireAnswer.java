package com.kuleuven.android.kuleuvenlibrary.submittedQuestionnaireClasses;

/**
 * SubmittedQuestionnaireAnswer
 * 
 * Class to hold the info about an Answer of a Question of a Submitted Questionnaire
 */
public class SubmittedQuestionnaireAnswer {
    private int id;
    private int typeId;
    private String prefix;
    private String answer;
    private String tooltip;
    private int sbmAnsId;


    /**
     * Public constructor SubmittedQuestionnaireAnswer with prefix
     */
    public SubmittedQuestionnaireAnswer(int id, int typeId, String answer, String tooltip, int sbmAnsId, String prefix){
        this.id = id;
        this.typeId = typeId;
        this.prefix = prefix;
        this.answer = answer;
        this.tooltip = tooltip;
        this.sbmAnsId = sbmAnsId;
    }

    /**
     * Public constructor SubmittedQuestionnaireAnswer without prefix
     */
    public SubmittedQuestionnaireAnswer(int id, int typeId, String answer, String tooltip, int sbmAnsId){
        this.id = id;
        this.typeId = typeId;
        this.prefix = "";
        this.answer = answer;
        this.tooltip = tooltip;
        this.sbmAnsId = sbmAnsId;
    }

    /**
     * Public constructor SubmittedQuestionnaireAnswer with prefix
     */
    public SubmittedQuestionnaireAnswer(int id, int typeId, String answer, String prefix){
        this.id = id;
        this.typeId = typeId;
        this.prefix = prefix;
        this.answer = answer;
    }


    public int getId() {
        return id;
    }

    public int getTypeId() {
        return typeId;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getAnswer() {
        return answer;
    }

}
