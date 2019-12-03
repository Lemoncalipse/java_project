package com.example.sportsbetting.interceptor;

import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 * Interceptor that allows for changing the current locale on every request, via a configurable request parameter (default parameter name: "locale").
 */
public class LanguageInterceptor extends LocaleChangeInterceptor {


    public LanguageInterceptor() {
        this.setParamName("lang");
    }

}
