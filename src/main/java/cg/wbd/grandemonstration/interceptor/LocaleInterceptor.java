package cg.wbd.grandemonstration.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class LocaleInterceptor implements HandlerInterceptor {
    private String langParam;

    public LocaleInterceptor(String param) {
        this.langParam = param;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String lang = request.getParameter(langParam);
        if (lang != null && !lang.isEmpty()) {
            Locale locale = Locale.forLanguageTag(lang);
            if (locale != null) {
                request.getSession().setAttribute("locale", locale);
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
