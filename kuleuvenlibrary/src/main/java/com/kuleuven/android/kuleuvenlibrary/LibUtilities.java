package com.kuleuven.android.kuleuvenlibrary;

import android.content.Context;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class LibUtilities {

    private static final String TAG = LibUtilities.class.getSimpleName();

    /**
     * Converts pixels to density-independent pixels.
     *
     * @param context needed to get resources
     * @param px to be converted
     * @return density-independent pixels
     */
    public static float dpFromPx(final Context context, final float px) {
        return px / context.getResources().getDisplayMetrics().density;
    }

    /**
     * Converts density-independent pixels to pixels.
     *
     * @param context needed to get resources
     * @param dp to be converted
     * @return pixels
     */
    public static float pxFromDp(final Context context, final float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }

    /**
     * Extracts a status code from a JSON response from the server.
     *
     * @param json response from the server
     * @return extracted status code
     *         -1 if an error occurred
     */
    public static int extractStatusCode(String json) {
        try {
            int statusCode = -1;
            JSONObject jObj = new JSONObject(json);
            JSONObject jStatus = jObj.getJSONObject("status");
            statusCode = jStatus.getInt("code");
            return statusCode;
        }
        catch (JSONException e){
            Log.e(TAG, "JSON Exception: " + e);
            return -1;
        }
    }

    /**
     * Extracts a status message from a JSON response from the server.
     *
     * @param json response from the server
     * @return extracted status message
     *         empty string if an error ocurred
     */
    public static String extractStatusMessage(String json) {
        try {
            String statusMessage = "";
            JSONObject jObj = new JSONObject(json);
            JSONObject jStatus = jObj.getJSONObject("status");
            statusMessage = jStatus.getString("message");
            return statusMessage;
        }
        catch (JSONException e){
            Log.e(TAG, "JSON Exception: " + e);
            return "";
        }
    }

    /**
     * Extracts an url from a JSON response from the server.
     *
     * @param json response from the server
     * @param urlToExtract determines which url to extract
     *                     ("current" or "update" or "development")
     * @return extracted url
     *         empty string if an error occurred
     */
    public static String extractUrl(String json, String urlToExtract) {
        try {
            String url = "";
            JSONObject jObj = new JSONObject(json);
            JSONObject jApi = jObj.getJSONObject("api");
            JSONObject jUrl = jApi.getJSONObject("url");
            url = jUrl.getString(urlToExtract);
            return url;
        }
        catch (JSONException e){
            Log.w(TAG, "JSON Exception: " + e);
            return "";
        }
    }

    /**
     * Extracts a version from a JSON response from the server.
     *
     * @param json response from the server
     * @param versionToExtract determines which version to extract
     *                         ("minimum" or "latest")
     * @param appPackageName determines which package name to extract
     *                       ("com.educat.android.educatapp" or
     *                       "com.educat.android.educatcontactapp" or
     *                       "com.educat.android.incaseapp")
     * @return extracted version
     *         empty string if an error occurred
     */
    public static String extractVersion(String json, String versionToExtract, String appPackageName) {
        try {
            String version = "";
            JSONObject jObj = new JSONObject(json);
            JSONObject jAppName = jObj.getJSONObject(appPackageName);
            JSONObject jVersion = jAppName.getJSONObject("version");
            version = jVersion.getString(versionToExtract);
            return version;
        }
        catch (JSONException e){
            Log.e(TAG, "JSON Exception: " + e);
            return "";
        }
    }

    // appPackageName: "com.educat.android.educatapp" or "com.educat.android.educatcontactapp" or "com.educat.android.incaseapp" or "com.nomade.android.nomadeapp"

    /**
     * Extracts a notice from a JSON response from the server.
     *
     * @param json response from the server
     * @param appPackageName determines which package name to extract
     *                       ("com.educat.android.educatapp" or
     *                       "com.educat.android.educatcontactapp" or
     *                       "com.educat.android.incaseapp")
     * @return extracted notice
     *         empty string if an error occurred
     */
    public static String extractNotice(String json, String appPackageName) {
        try {
            String notice = "";
            JSONObject jObj = new JSONObject(json);
            JSONObject jAppName = jObj.getJSONObject(appPackageName);
            notice = jAppName.getString("notice");
            return notice;
        }
        catch (JSONException e){
            Log.w(TAG, "JSON Exception: " + e);
            return "";
        }
    }

    /**
     * Extracts a general notice from a JSON response from the server.
     *
     * @param json response from the server
     * @return extracted general notice
     *         empty string if an error occurred
     */
    public static String extractGeneralNotice(String json) {
        try {
            String generalNotice = "";
            JSONObject jObj = new JSONObject(json);
            generalNotice = jObj.getString("notice");
            return generalNotice;
        }
        catch (JSONException e){
            Log.w(TAG, "JSON Exception: " + e);
            return "";
        }
    }

    /**
     * Prints a giant log to the logcat by splitting the log.
     *
     * @param tag for the log
     * @param s message for the log
     */
    private static void printGiantLog(String tag, String s) {
        int maxLogSize = 4000;
        for(int i = 0; i <= s.length() / maxLogSize; i++) {
            int start = i * maxLogSize;
            int end = (i+1) * maxLogSize;
            end = end > s.length() ? s.length() : end;
            Log.d(tag, s.substring(start, end));
        }
    }

    /**
     * Prints a giant log to the logcat by splitting the log.
     *
     * @param tag for the log
     * @param s message for the log
     * @param activate prints the entire log when true
     *                 prints only the first part of the log when false
     */
    public static void printGiantLog(String tag, String s, boolean activate) {
        if (activate){
            printGiantLog(tag, s);
        }
        else {
            Log.d(tag, s);
        }
    }

}
