package com.gioov.spiny.system.service.impl;

import com.gioov.spiny.system.entity.DictionaryEntity;
import com.gioov.spiny.system.mapper.DictionaryMapper;
import com.gioov.spiny.system.service.DictionaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author godcheese
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    private DictionaryMapper dictionaryMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(DictionaryServiceImpl.class);

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void modelAndViewAddDictionary(ModelAndView modelAndView) {
        if (modelAndView != null) {

            modelAndView.addAllObjects(keyValueMap());
        }
    }


    private String getValueByKeyAndValueSlug(String key, String valueSlug) {
        DictionaryEntity dictionaryEntity = dictionaryMapper.getOneByKeyAndValueSlug(key, valueSlug);
        if (dictionaryEntity != null) {
            return dictionaryEntity.getValue();
        }
        return null;
    }

    @Override
    public String get(String key, String valueSlug) {
        return getValueByKeyAndValueSlug(key, valueSlug);
    }

    @Override
    public String get(String key, String valueSlug, String defaultValue) {
        String v = getValueByKeyAndValueSlug(key, valueSlug);
        if (v != null) {
            return v;
        }
        return defaultValue;
    }

    @Override
    public Map<String, Map<String, Object>> keyValueMap() {
        Map<String, Map<String, Object>> mapMap = new HashMap<>();
        List<DictionaryEntity> dictionaryEntityList = dictionaryMapper.listAll();
        if (dictionaryEntityList != null) {
            for (DictionaryEntity dictionaryEntity : dictionaryEntityList) {
                if (mapMap.containsKey(dictionaryEntity.getKey())) {
                    Map<String, Object> valueMap = mapMap.get(dictionaryEntity.getKey());
                    if (!valueMap.containsKey(dictionaryEntity.getValueSlug())) {
                        valueMap.put(dictionaryEntity.getValueSlug(), dictionaryEntity.getValue());
                    }
                    mapMap.put(dictionaryEntity.getKey(), valueMap);
                } else {
                    Map<String, Object> valueMap = new HashMap<>(1);
                    valueMap.put(dictionaryEntity.getValueSlug(), dictionaryEntity.getValue());
                    mapMap.put(dictionaryEntity.getKey(), valueMap);
                }
            }
        }

        return mapMap;
    }

}
