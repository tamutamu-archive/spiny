package com.gioov.spiny.system.service;

import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author godcheese
 */
public interface DictionaryService {

    /**
     * 获取字典为 Map
     *
     * @param modelAndView
     */
    void modelAndViewAddDictionary(ModelAndView modelAndView);


    /**
     * 获取字典值
     *
     * @param key
     * @param valueSlug
     * @return
     */
    String get(String key, String valueSlug);

    String get(String key, String valueSlug, String defaultValue);

    Map<String, Map<String, Object>> keyValueMap();

}
