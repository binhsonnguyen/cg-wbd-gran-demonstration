package cg.wbd.grandemonstration.controller;

import javax.servlet.http.HttpServletRequest;

interface RequestSupport {
    String ACTION_EDIT = "EDIT";

    static String getActionValue(HttpServletRequest req) {
        String action = req.getParameter("action");
        return action == null ? "" : action.toUpperCase();
    }

    static boolean isDefault(String action) {
        return action.isEmpty();
    }

    static boolean isEdit(String action) {
        return action.equals(ACTION_EDIT);
    }
}
