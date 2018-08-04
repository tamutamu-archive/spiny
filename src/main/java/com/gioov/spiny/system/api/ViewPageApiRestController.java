package com.gioov.spiny.system.api;

import com.gioov.common.web.http.FailureEntity;
import com.gioov.spiny.common.constant.Api;
import com.gioov.spiny.system.entity.ViewPageApiEntity;
import com.gioov.spiny.system.mapper.ViewPageApiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.gioov.spiny.user.service.UserService.SYSTEM_ADMIN;

/**
 * @author godcheese
 * @date 2018/5/22
 */
@RestController
@RequestMapping(Api.System.VIEW_PAGE_API)
public class ViewPageApiRestController {

    private static final String VIEW_PAGE_API = "/API/SYSTEM/VIEW_PAGE_API";

    @Autowired
    private ViewPageApiMapper viewPageApiMapper;

    /**
     * 是否关联 API
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + VIEW_PAGE_API + "/IS_ASSOCIATED_BY_PAGE_ID_AND_API_ID')")
    @RequestMapping(value = "/is_associated_by_page_id_and_api_id", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> isAssociatedByPageIdAndApiId(@RequestParam Long pageId, @RequestParam Long apiId) {
        Map<String, Object> data = new HashMap<>(1);
        data.put("isAssociated", false);

        try {
            ViewPageApiEntity viewPageApiEntity = viewPageApiMapper.getOneByPageIdAndApiId(pageId, apiId);

            if (viewPageApiEntity != null) {
                data.put("isAssociated", true);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(data, HttpStatus.OK);
    }


    /**
     * 批量关联 API
     *
     * @param pageId
     * @param apiIdArray
     * @return
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + VIEW_PAGE_API + "/ASSOCIATE_ALL_BY_PAGE_ID_AND_API_ID_LIST')")
    @RequestMapping(value = "/associate_all_by_page_id_and_api_id_list", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> associateAllByPageIdAndApiIdList(@RequestParam Long pageId, @RequestParam("apiIdList[]") String[] apiIdArray) {

        List<Long> apiIdList = new ArrayList<>();
        ViewPageApiEntity viewPageApiEntity = null;

        try {
            for (String apiId : apiIdArray) {
                if (!"".equals(apiId.trim())) {
                    viewPageApiEntity = viewPageApiMapper.getOneByPageIdAndApiId(pageId, Long.valueOf(apiId));
                    if (viewPageApiEntity == null) {
                        apiIdList.add(Long.valueOf(apiId));
                    }
                }
            }

            if (!apiIdList.isEmpty()) {
                viewPageApiMapper.insertAllByPageIdAndApiIdList(pageId, apiIdList);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(apiIdList, HttpStatus.OK);
    }

    /**
     * 指定视图页面 id、API id ，批量撤销关联
     *
     * @param pageId
     * @param apiIdArray
     * @return
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + VIEW_PAGE_API + "/REVOKE_ALL_BY_ROLE_ID_AND_AUTHORITY')")
    @RequestMapping(value = "/revoke_associate_all_by_page_id_and_api_id_list", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> revokeAssociateAllByPageIdAndApiIdList(@RequestParam Long pageId, @RequestParam("apiIdList[]") String[] apiIdArray) {
        int result = 0;
        List<Long> apiIdList = new ArrayList<>();
        try {
            for (String apiId : apiIdArray) {
                if (!"".equals(apiId.trim())) {
                    apiIdList.add(Long.valueOf(apiId));
                }
            }
            if (!apiIdList.isEmpty()) {
                viewPageApiMapper.deleteAllByPageIdAndApiIdList(pageId, apiIdList);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
