package com.kuleuven.android.kuleuvenlibrary.getQuestionnaireClasses;

/**
 * Answer
 *
 * Class to hold the info about an Answer of a Question of a Questionnaire
 */
public class Answer {

    private int id;
    private int typeId;
    private String prefix; // In case of fixed prefix = value
    private String tooltip;
    private boolean hasOptions;
    private int optionsMinInt;
    private int optionsMaxInt;
    private double optionsMinDouble;
    private double optionsMaxDouble;

    public static final int FIXED = 1; // Fixed
    public static final int INTEGER = 10; // Integer
    public static final int DOUBLE = 11; // Double
    public static final int SCALE = 20; // Scale
    public static final int YES_NO = 25; // Yes/No
    public static final int DATE = 30; // Date
    public static final int DATE_PAST = 31; // Date (Past)
    public static final int DATE_FUTURE = 32; // Date (Future)
    public static final int DATETIME = 33; // Datetime
    public static final int DATETIME_PAST = 34; // Datetime (Past)
    public static final int DATETIME_FUTURE = 35; // Datetime (Future)
    public static final int TIME_HH_MM = 36; // Time (hh:mm)
    public static final int TIME_HH_MM_SS = 37; // Time (hh:mm:ss)
    public static final int OPTIONAL_CUSTOM = 98; // Optional custom
    public static final int MANDATORY_CUSTOM = 99; // Mandatory custom


    /**
     * Public constructor Answer without options
     */
    public Answer(int id, int typeId, String prefix, String tooltip){
        this.id = id;
        this.typeId = typeId;
        this.prefix = prefix;
        this.tooltip = tooltip;
        this.hasOptions = false;
        this.optionsMinInt = -1;
        this.optionsMaxInt = -1;
        this.optionsMinDouble = -1;
        this.optionsMaxDouble = -1;
    }

    /**
     * Public Constructor Answer with integer options
     */
    public Answer(int id, int typeId, String value, String tooltip, int optionsMinInt, int optionsMaxInt){
        this.id = id;
        this.typeId = typeId;
        this.prefix = value;
        this.tooltip = tooltip;
        this.hasOptions = true;
        this.optionsMinInt = optionsMinInt;
        this.optionsMaxInt = optionsMaxInt;
        this.optionsMinDouble = -1;
        this.optionsMaxDouble = -1;
    }

    /**
     * Public Constructor Answer with double options
     */
    public Answer(int id, int typeId, String value, String tooltip, double optionsMinDouble, double optionsMaxDouble){
        this.id = id;
        this.typeId = typeId;
        this.prefix = value;
        this.tooltip = tooltip;
        this.hasOptions = true;
        this.optionsMinInt = -1;
        this.optionsMaxInt = -1;
        this.optionsMinDouble = optionsMinDouble;
        this.optionsMaxDouble = optionsMaxDouble;
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

    public String getTooltip() {
        return tooltip;
    }

    public boolean isHasOptions() {
        return hasOptions;
    }

    public int getOptionsMinInt() {
        return optionsMinInt;
    }

    public int getOptionsMaxInt() {
        return optionsMaxInt;
    }

    public double getOptionsMinDouble() {
        return optionsMinDouble;
    }

    public double getOptionsMaxDouble() {
        return optionsMaxDouble;
    }

}
