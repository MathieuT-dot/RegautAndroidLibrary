package com.kuleuven.android.kuleuvenlibrary;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.kuleuven.android.kuleuvenlibrary.getQuestionnaireClasses.Answer;
import com.kuleuven.android.kuleuvenlibrary.getQuestionnaireClasses.Question;
import com.kuleuven.android.kuleuvenlibrary.getQuestionnaireClasses.Questionnaire;
import com.kuleuven.android.kuleuvenlibrary.submittedQuestionnaireClasses.SubmittedQuestionnaire;
import com.kuleuven.android.kuleuvenlibrary.submittedQuestionnaireClasses.SubmittedQuestionnaireAnswer;
import com.kuleuven.android.kuleuvenlibrary.submittedQuestionnaireClasses.SubmittedQuestionnaireQuestion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * JsonLib
 *
 * Class that holds multiple methods to parse JSON strings
 */
public class JsonLib {

    private static final String TAG = JsonLib.class.getSimpleName();

    /**
     * Displays a toast.
     *
     * @param context to show the toast
     * @param text to be shown in the toast
     */
    private static void displayToast(Context context, String text) {
        Toast toast = Toast.makeText(context, text, Toast.LENGTH_LONG);
        toast.show();
    }

    /**
     * Parses a JSON containing a questionnaire.
     *
     * @param context to display the toast
     * @param response JSON containing a questionnaire
     * @return the parsed questionnaire
     */
    public static Questionnaire parseJsonQuestionnaire(Context context, String response) {

        try{
            JSONObject jObj = new JSONObject(response);

            JSONObject jQuestionnaire = jObj.getJSONObject("questionnaire");

            int questionnaireId = jQuestionnaire.getInt("id");
            int groupId = jQuestionnaire.getInt("group_id");
            int version = jQuestionnaire.getInt("version");
            String questionnaireTitle = jQuestionnaire.getString("title");
            String description = jQuestionnaire.getString("description");
            boolean draft = jQuestionnaire.getInt("draft") == 1;
            int editable = jQuestionnaire.getInt("editable");
            String language = jQuestionnaire.getString("language");
            int questionCount = jQuestionnaire.getInt("count");

            JSONArray jQuestionsArray= jQuestionnaire.getJSONArray("questions");

            ArrayList<Question> questionList = new ArrayList<>();

            for (int i = 0; i < jQuestionsArray.length(); i++){

                JSONObject jCurrentQuestion = jQuestionsArray.getJSONObject(i);

                int questionId = jCurrentQuestion.getInt("id");
                String question = jCurrentQuestion.getString("question");
                String questionTooltip = jCurrentQuestion.getString("tooltip");
                int bulletType = jCurrentQuestion.getInt("bullet_type");
                int conditional = jCurrentQuestion.getInt("conditional");
                int answerCount = jCurrentQuestion.getInt("count");

                JSONArray jAnswersArray = jCurrentQuestion.getJSONArray("answers");

                ArrayList<Answer> answerList = new ArrayList<>();

                for (int j = 0; j < jAnswersArray.length(); j++){

                    JSONObject jCurrentAnswer = jAnswersArray.getJSONObject(j);

                    int answerId = jCurrentAnswer.getInt("id");
                    int typeId = jCurrentAnswer.getInt("type_id");
                    String prefix;
                    if (typeId == 1){
                        prefix = jCurrentAnswer.getString("fixed");
                    }
                    else {
                        prefix = jCurrentAnswer.getString("prefix");
                    }

                    String tooltip = jCurrentAnswer.getString("tooltip");

                    if (jCurrentAnswer.has("options") || typeId == 20 || typeId == 25){
                        JSONObject jOptions;
                        try {
                            jOptions = jCurrentAnswer.getJSONObject("options");
                        }
                        catch (Exception e){
                            jOptions = null;
                        }

                        switch (typeId){
                            case 10:
                                int optionsMinInt;
                                try {
                                    assert jOptions != null;
                                    optionsMinInt = jOptions.getInt("min");
                                }
                                catch (Exception e) {
                                    optionsMinInt = Integer.MIN_VALUE;
                                }

                                int optionsMaxInt;
                                try {
                                    optionsMaxInt= jOptions.getInt("max");
                                }
                                catch (Exception e){
                                    optionsMaxInt = Integer.MAX_VALUE;
                                }

                                answerList.add(new Answer(answerId, typeId, prefix, tooltip, optionsMinInt, optionsMaxInt));
                                break;

                            case 11:
                                double optionsMinDouble;
                                try {
                                    assert jOptions != null;
                                    optionsMinDouble= jOptions.getDouble("min");
                                }
                                catch (Exception e){
                                    optionsMinDouble = Double.NEGATIVE_INFINITY;
                                }

                                double optionsMaxDouble;
                                try {
                                    optionsMaxDouble= jOptions.getDouble("max");
                                }
                                catch (Exception e){
                                    optionsMaxDouble = Double.POSITIVE_INFINITY;
                                }

                                answerList.add(new Answer(answerId, typeId, prefix, tooltip, optionsMinDouble, optionsMaxDouble));
                                break;

                            case 20:
                                try {
                                    assert jOptions != null;
                                    optionsMinInt = jOptions.getInt("min");
                                    optionsMaxInt= jOptions.getInt("max");
                                }
                                catch (Exception e){
                                    optionsMinInt = 0;
                                    optionsMaxInt= 10;
                                }

                                answerList.add(new Answer(answerId, typeId, prefix, tooltip, optionsMinInt, optionsMaxInt));
                                break;

                            case 25:
                                try {
                                    assert jOptions != null;
                                    optionsMinInt = jOptions.getInt("min");
                                    optionsMaxInt= jOptions.getInt("max");
                                }
                                catch (Exception e){
                                    optionsMinInt = 0;
                                    optionsMaxInt= 1;
                                }

                                answerList.add(new Answer(answerId, typeId, prefix, tooltip, optionsMinInt, optionsMaxInt));
                                break;
                        }
                    }
                    else {
                        answerList.add(new Answer(answerId, typeId, prefix, tooltip));
                    }
                }

                /*
                  If there is a condition, get the condition and use constructor with condition
                  Otherwise just use constructor without condition
                 */
                if (conditional == 1) {
                    JSONObject jCondition = jCurrentQuestion.getJSONObject("condition");

                    int conditionQuestionId = jCondition.getInt("question_id");
                    int conditionAnswerId = jCondition.getInt("answer_id");

                    questionList.add(new Question(questionId, question, questionTooltip, bulletType, conditional, answerCount, answerList, conditionQuestionId, conditionAnswerId));
                }
                else {
                    questionList.add(new Question(questionId, question,  questionTooltip, bulletType, conditional, answerCount, answerList));
                }
            }

            return new Questionnaire(questionnaireId, groupId, version, questionnaireTitle, description, draft, editable, language, questionCount, questionList);

        } catch (JSONException e) {
            Log.e(TAG, "JSONException " + context.getString(R.string.error_colon) + e.getMessage());
            displayToast(context, TAG + " | JSONException " + context.getString(R.string.error_colon) + e.getMessage());
        }

        return null;
    }

    /**
     * Parses a JSON containing a submitted questionnaire.
     *
     * @param context to display the toast
     * @param response JSON containing a submitted questionnaire
     * @return the parsed submitted questionnaire
     */
    public static SubmittedQuestionnaire parseJsonSubmittedQuestionnaire(Context context, String response) {

        try {

            JSONObject jObj = new JSONObject(response);

            JSONObject jSubmission = jObj.getJSONObject("submission");

            int submissionId = jSubmission.getInt("id");
            int qnrId = jSubmission.getInt("qnr_id");
            int groupId = jSubmission.getInt("group_id");
            int version = jSubmission.getInt("version");
            String title = jSubmission.getString("title");
            String description = jSubmission.getString("description");

            int userId = jSubmission.getInt("user_id");

            String date = jSubmission.getString("date");
            long unixMillis = jSubmission.getLong("unix_millis");
            long origMillis = jSubmission.getLong("orig_millis");

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            Date result;

            long lastEditMillis = 0;
            String editDate = "";
            if (jSubmission.has("last_edit_millis")){
                lastEditMillis = jSubmission.getLong("last_edit_millis");
                result = new Date(lastEditMillis);
                editDate = sdf.format(result);
                System.out.println("Edit date: " + editDate + " | Millis: " + lastEditMillis);
            }

            result = new Date(origMillis);
            String origDate = sdf.format(result);
            System.out.println("Original date: " + origDate + " | String date: " + date);

            if (!origDate.equals(date)){
                System.out.println("Original date and string date not equal, using original date");
                date = origDate;
            }

            String language = jSubmission.getString("language");
            int questionsCount = jSubmission.getInt("count");

            JSONArray jQuestionsArray = jSubmission.getJSONArray("questions");

            ArrayList<SubmittedQuestionnaireQuestion> questionList = new ArrayList<>();

            for (int i = 0; i < jQuestionsArray.length(); i++){

                JSONObject jCurrentQuestion= jQuestionsArray.getJSONObject(i);

                int questionId = jCurrentQuestion.getInt("id");
                String question = jCurrentQuestion.getString("question");
                int bulletType = jCurrentQuestion.getInt("bullet_type");
                int conditional = jCurrentQuestion.getInt("conditional");
                int answersCount =  jCurrentQuestion.getInt("count");

                JSONArray jAnswersArray = jCurrentQuestion.getJSONArray("answers");

                ArrayList<SubmittedQuestionnaireAnswer> answerList = new ArrayList<>();

                for(int j = 0; j < jAnswersArray.length(); j++){

                    JSONObject jCurrentAnswer = jAnswersArray.getJSONObject(j);

                    int answerId = jCurrentAnswer.getInt("id");
                    int typeId = jCurrentAnswer.getInt("type_id");
                    String answer = jCurrentAnswer.getString("answer");
                    String tooltip = jCurrentAnswer.getString("tooltip");
                    int sbmAnsId = jCurrentAnswer.getInt("sbm_ans_id");

                    if (jCurrentAnswer.has("prefix")){
                        String prefix = jCurrentAnswer.getString("prefix");

                        answerList.add(new SubmittedQuestionnaireAnswer(answerId, typeId, answer, tooltip, sbmAnsId, prefix));
                    }
                    else {
                        answerList.add(new SubmittedQuestionnaireAnswer(answerId, typeId, answer, tooltip, sbmAnsId));
                    }

                }

                questionList.add(new SubmittedQuestionnaireQuestion(questionId, question, bulletType, conditional, answersCount, answerList));
            }

            return new SubmittedQuestionnaire(submissionId, qnrId,groupId, version, title, description, userId, date, editDate, unixMillis, origMillis, lastEditMillis, language, questionsCount, questionList);

        } catch (JSONException e) {
            Log.e(TAG, "JSONException Error: " + e.toString() + " | " + e.getMessage());
            displayToast(context, TAG + " | JSONException " + context.getString(R.string.error_colon) + e.toString() + " | " + e.getMessage());
        }

        return null;
    }
}
