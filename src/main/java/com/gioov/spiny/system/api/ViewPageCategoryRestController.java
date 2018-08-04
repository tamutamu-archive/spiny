package com.gioov.spiny.system.api;

import com.gioov.common.mybatis.Pageable;
import com.gioov.common.web.exception.BaseResponseException;
import com.gioov.common.web.http.FailureEntity;
import com.gioov.spiny.common.constant.Api;
import com.gioov.spiny.common.constant.FailureMessage;
import com.gioov.spiny.common.easyui.Pagination;
import com.gioov.spiny.system.entity.ViewPageCategoryEntity;
import com.gioov.spiny.system.entity.ViewPageEntity;
import com.gioov.spiny.system.mapper.ViewPageCategoryMapper;
import com.gioov.spiny.system.mapper.ViewPageMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static com.gioov.spiny.user.service.UserService.SYSTEM_ADMIN;

/**
 * @author godcheese
 * @date 2018/4/25 14:41
 */
@RestController
@RequestMapping(value = Api.System.VIEW_PAGE_CATEGORY, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ViewPageCategoryRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ViewPageCategoryRestController.class);

    private static final String VIEW_PAGE_CATEGORY = "/API/SYSTEM/VIEW_PAGE_CATEGORY";

    @Autowired
    private ViewPageCategoryMapper viewPageCategoryMapper;

    @Autowired
    private ViewPageMapper viewPageMapper;

    /**
     * 分页获取所有父级视图页面分类
     *
     * @param page
     * @param rows
     * @return
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + VIEW_PAGE_CATEGORY + "/PAGE_ALL_PARENT')")
    @RequestMapping(value = "/page_all_parent", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> pageAllParent(@RequestParam Integer page, @RequestParam Integer rows) {
        List<ViewPageCategoryEntity> viewPageCategoryEntityList = null;
        Pagination.Result<ViewPageCategoryEntity> paginationResult = new Pagination().new Result<>();

        try {
            viewPageCategoryEntityList = viewPageCategoryMapper.pageAllByParentIdIsNull(new Pageable(page, rows));
            if (viewPageCategoryEntityList != null) {
                paginationResult.setRows(viewPageCategoryEntityList);
            }
            int count = viewPageCategoryMapper.countAllByParentIdIsNull();
            paginationResult.setTotal(count);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(paginationResult, HttpStatus.OK);
    }

    /**
     * 指定父级视图页面分类 id ，获取所有视图页面分类
     *
     * @param id
     * @return
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + VIEW_PAGE_CATEGORY + "/LIST_ALL_BY_PARENT_ID')")
    @RequestMapping(value = "/list_all_by_parent_id/{id}", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> listAllByParentId(@PathVariable Long id) {
        List<ViewPageCategoryEntity> viewPageCategoryEntityList = null;
        try {
            viewPageCategoryEntityList = viewPageCategoryMapper.listAllByParentId(id);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(viewPageCategoryEntityList, HttpStatus.OK);
    }

    /**
     * 新增视图页面分类
     *
     * @param name
     * @param parentId
     * @param sort
     * @param remark
     * @return
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + VIEW_PAGE_CATEGORY + "/ADD_ONE')")
    @RequestMapping(value = "/add_one", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> addOne(@RequestParam String name, @RequestParam(required = false) Long parentId, @RequestParam Long sort, @RequestParam String remark) {
        ViewPageCategoryEntity viewPageCategoryEntity = null;
        Date date = new Date();
        try {
            viewPageCategoryEntity = new ViewPageCategoryEntity();
            viewPageCategoryEntity.setName(name);
            viewPageCategoryEntity.setParentId(parentId);
            viewPageCategoryEntity.setSort(sort);
            viewPageCategoryEntity.setRemark(remark);
            viewPageCategoryEntity.setGmtModified(date);
            viewPageCategoryEntity.setGmtCreated(date);
            viewPageCategoryMapper.insertOne(viewPageCategoryEntity);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(viewPageCategoryEntity, HttpStatus.OK);
    }

    /**
     * 保存视图页面分类
     *
     * @param id
     * @param name
     * @param sort
     * @param remark
     * @return
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + VIEW_PAGE_CATEGORY + "/SAVE_ONE')")
    @RequestMapping(value = "/save_one", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> saveOne(@RequestParam Long id, @RequestParam String name, @RequestParam Long sort, @RequestParam String remark) {
        ViewPageCategoryEntity viewPageCategoryEntity = null;
        Date date = new Date();
        try {
            viewPageCategoryEntity = viewPageCategoryMapper.getOne(id);
            viewPageCategoryEntity.setName(name);
            viewPageCategoryEntity.setSort(sort);
            viewPageCategoryEntity.setRemark(remark);
            viewPageCategoryEntity.setGmtModified(date);
            viewPageCategoryMapper.updateOne(viewPageCategoryEntity);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(viewPageCategoryEntity, HttpStatus.OK);
    }

//    /**
//     * 删除
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/delete_one", method = RequestMethod.POST)
//    public String deleteOne(@RequestParam Long id) {
//        BaseStatus.CustomStatus baseStatus = BaseStatus.CustomStatus.NOT_FOUND;
//        String message = "删除失败";
//        Exception exception = null;
//        int result = 0;
//        try {
//            List<ViewPageCategoryEntity> viewPageCategoryEntityList = viewPageCategoryMapper.listAllByParentId(id);
//            if(viewPageCategoryEntityList!=null && !viewPageCategoryEntityList.isEmpty()){
//                throw new BaseResponseException("删除失败，该分类下存在子级分类");
//            }
//            List<ViewPageEntity> viewPageEntityList = viewPageMapper.listAllByPageCategoryId(id);
//            if(viewPageEntityList!=null && !viewPageEntityList.isEmpty()){
//                throw new BaseResponseException("删除失败，该分类下存在页面");
//            }
//
//            result = viewPageCategoryMapper.deleteOne(id);
//            baseStatus = BaseStatus.CustomStatus.OK;
//            message = "删除成功";
//        } catch (BaseResponseException e) {
//            e.printStackTrace();
//            exception = e;
//            message = e.getMessage();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            exception = e;
//        }
//        return BaseResponse.result(baseStatus, result, message, exception);
//    }

    /**
     * 指定视图页面分类 id ，批量删除视图页面分类
     *
     * @param idList
     * @return
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + VIEW_PAGE_CATEGORY + "/DELETE_ALL')")
    @RequestMapping(value = "/delete_all", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> deleteAll(@RequestParam("id[]") List<Long> idList) {
        int result = 0;
        try {

            for (Long id : idList) {
                ViewPageCategoryEntity viewPageCategoryEntity = viewPageCategoryMapper.getOneByParentId(id);
                if (viewPageCategoryEntity != null) {
                    throw new BaseResponseException(FailureMessage.DELETE_VIEW_PAGE_CATEGORY_FAIL1);
                }
                ViewPageEntity viewPageEntity = viewPageMapper.getOneByPageCategoryId(id);
                if (viewPageEntity != null) {
                    throw new BaseResponseException(FailureMessage.DELETE_VIEW_PAGE_CATEGORY_FAIL2);
                }
            }

            result = viewPageCategoryMapper.deleteAll(idList);

        } catch (BaseResponseException e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(e), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 指定视图页面分类 id ，获取视图页面分类信息
     *
     * @param id
     * @return
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + VIEW_PAGE_CATEGORY + "/ONE')")
    @RequestMapping(value = "/one/{id}", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> getOne(@PathVariable Long id) {
        ViewPageCategoryEntity viewPageCategoryEntity = null;
        try {
            viewPageCategoryEntity = viewPageCategoryMapper.getOne(id);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(viewPageCategoryEntity, HttpStatus.OK);
    }

}
