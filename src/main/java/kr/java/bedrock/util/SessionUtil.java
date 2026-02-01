package kr.java.bedrock.util;

import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SessionUtil {

    private static final String HISTORY_KEY = "history";

    @SuppressWarnings("unchecked")
    public static List<Map<String, String>> getChatHistory(HttpSession session) {
        Object attribute = session.getAttribute(HISTORY_KEY);
        
        if (attribute instanceof List<?>) {
            try {
                return (List<Map<String, String>>) attribute;
            } catch (ClassCastException e) {
                // In case of unexpected type issues, fall through to create new
            }
        }
        
        List<Map<String, String>> history = new ArrayList<>();
        session.setAttribute(HISTORY_KEY, history);
        return history;
    }
}
