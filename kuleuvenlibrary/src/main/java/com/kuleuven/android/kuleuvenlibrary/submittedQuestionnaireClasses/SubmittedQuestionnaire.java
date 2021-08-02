package com.kuleuven.android.kuleuvenlibrary.submittedQuestionnaireClasses;

import java.util.ArrayList;

/**
 * SubmittedQuestionnaire
 * 
 * Class to hold the info about a Submitted Questionnaire
 */
public class SubmittedQuestionnaire {

    private int id;
    private int qnrId;
    private int groupId;
    private int version;
    private String title;
    private String description;
    private int userId;
    private String userName;
    private String date;
    private String editDate;
    private long unixMillis;
    private long origMillis;
    private long lastEditMillis;
    private String language;
    private int count;
    private ArrayList<SubmittedQuestionnaireQuestion> questionsList;

    private String startedAt;
    private String finishedAt;
    private int previousSubmissionId;
    private int nextSubmissionId;
    
    public SubmittedQuestionnaire(int id, int qnrId, int groupId, int version, String title, String description, int userId, String userName, String date, String editDate, long unixMillis, long origMillis, long lastEditMillis) {
        this.id = id;
        this.qnrId = qnrId;
        this.groupId = groupId;
        this.version = version;
        this.title = title;
        this.description = description;
        this.userId = userId;
        this.userName = userName;
        this.date = date;
        this.editDate = editDate;
        this.unixMillis = unixMillis;
        this.origMillis = origMillis;
        this.lastEditMillis = lastEditMillis;
        this.language = "";
        this.count = -1;
        this.questionsList = null;
    }

    public SubmittedQuestionnaire(int id, int qnrId, int groupId, int version, String title, String description, int userId, String userName, String date, String editDate) {
        this.id = id;
        this.qnrId = qnrId;
        this.groupId = groupId;
        this.version = version;
        this.title = title;
        this.description = description;
        this.userId = userId;
        this.userName = userName;
        this.date = date;
        this.editDate = editDate;
        this.language = "";
        this.count = -1;
        this.questionsList = null;
    }

    public SubmittedQuestionnaire(int id, int qnrId, int groupId, int version, String title, String description, int userId, String userName, String date, String editDate, int previousSubmissionId, int nextSubmissionId) {
        this.id = id;
        this.qnrId = qnrId;
        this.groupId = groupId;
        this.version = version;
        this.title = title;
        this.description = description;
        this.userId = userId;
        this.userName = userName;
        this.date = date;
        this.editDate = editDate;
        this.language = "";
        this.count = -1;
        this.questionsList = null;
        this.previousSubmissionId = previousSubmissionId;
        this.nextSubmissionId = nextSubmissionId;
    }

    public SubmittedQuestionnaire(int id, int qnrId, int groupId, int version, String title, String description, int userId, String date, String editDate, long unixMillis, long origMillis, long lastEditMillis) {
        this.id = id;
        this.qnrId = qnrId;
        this.groupId = groupId;
        this.version = version;
        this.title = title;
        this.description = description;
        this.userId = userId;
        this.date = date;
        this.editDate = editDate;
        this.unixMillis = unixMillis;
        this.origMillis = origMillis;
        this.lastEditMillis = lastEditMillis;
        this.language = "";
        this.count = -1;
        this.questionsList = null;
    }

    public SubmittedQuestionnaire(int id, int qnrId, int groupId, int version, String title, String description, int userId, String date, String editDate, long unixMillis, long origMillis, long lastEditMillis, String language, int count, ArrayList<SubmittedQuestionnaireQuestion> questionList) {
        this.id = id;
        this.qnrId = qnrId;
        this.groupId = groupId;
        this.version = version;
        this.title = title;
        this.description = description;
        this.userId = userId;
        this.date = date;
        this.editDate = editDate;
        this.unixMillis = unixMillis;
        this.origMillis = origMillis;
        this.lastEditMillis = lastEditMillis;
        this.language = language;
        this.count = count;
        this.questionsList = questionList;
    }

    public SubmittedQuestionnaire(int id, int qnrId, int groupId, int version, String title, String description, int userId, String date, String editDate, String startedAt, String finishedAt, int previousSubmissionId, int nextSubmissionId, ArrayList<SubmittedQuestionnaireQuestion> questionList) {
        this.id = id;
        this.qnrId = qnrId;
        this.groupId = groupId;
        this.version = version;
        this.title = title;
        this.description = description;
        this.userId = userId;
        this.date = date;
        this.editDate = editDate;
        this.startedAt = startedAt;
        this.finishedAt = finishedAt;
        this.previousSubmissionId = previousSubmissionId;
        this.nextSubmissionId = nextSubmissionId;
        this.questionsList = questionList;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQnrId() {
        return qnrId;
    }

    public void setQnrId(int qnrId) {
        this.qnrId = qnrId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEditDate() {
        return editDate;
    }

    public void setEditDate(String editDate) {
        this.editDate = editDate;
    }

    public long getUnixMillis() {
        return unixMillis;
    }

    public void setUnixMillis(long unixMillis) {
        this.unixMillis = unixMillis;
    }

    public long getOrigMillis() {
        return origMillis;
    }

    public void setOrigMillis(long origMillis) {
        this.origMillis = origMillis;
    }

    public long getLastEditMillis() {
        return lastEditMillis;
    }

    public void setLastEditMillis(long lastEditMillis) {
        this.lastEditMillis = lastEditMillis;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<SubmittedQuestionnaireQuestion> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(ArrayList<SubmittedQuestionnaireQuestion> questionsList) {
        this.questionsList = questionsList;
    }

    public String getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(String startedAt) {
        this.startedAt = startedAt;
    }

    public String getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(String finishedAt) {
        this.finishedAt = finishedAt;
    }

    public int getPreviousSubmissionId() {
        return previousSubmissionId;
    }

    public void setPreviousSubmissionId(int previousSubmissionId) {
        this.previousSubmissionId = previousSubmissionId;
    }

    public int getNextSubmissionId() {
        return nextSubmissionId;
    }

    public void setNextSubmissionId(int nextSubmissionId) {
        this.nextSubmissionId = nextSubmissionId;
    }
}
