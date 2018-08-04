package com.gioov.spiny.user.api;

import com.gioov.common.mybatis.Pageable;
import com.gioov.common.web.http.FailureEntity;
import com.gioov.spiny.common.constant.Api;
import com.gioov.spiny.common.constant.FailureMessage;
import com.gioov.spiny.common.easyui.Pagination;
import com.gioov.spiny.user.entity.UserEntity;
import com.gioov.spiny.user.mapper.UserMapper;
import com.gioov.spiny.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.gioov.spiny.user.service.UserService.SYSTEM_ADMIN;

/**
 * @author godcheese
 * @date 2018/4/26 8:48
 */
@RestController
@RequestMapping(value = Api.USER, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRestController.class);

    private static final String USER = "/API/USER";

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    /**
     * 分页获取用户
     *
     * @param page
     * @param rows
     * @return
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + USER + "/PAGE_ALL')")
    @RequestMapping(value = "/page_all", method = RequestMethod.GET)
    public ResponseEntity pageAll(@RequestParam Integer page, @RequestParam Integer rows) {
        List<UserEntity> userEntityList = new ArrayList<>();
        Pagination.Result<UserEntity> paginationResult = new Pagination().new Result<>();

        try {

            List<UserEntity> tempUserEntityList = userMapper.pageAll(new Pageable(page, rows));
            if (tempUserEntityList != null) {
                for (UserEntity userEntity : tempUserEntityList) {
                    userEntity.setPassword(null);
                    userEntityList.add(userEntity);
                }
            }

            paginationResult.setRows(userEntityList);
            int count = userMapper.countAll();
            paginationResult.setTotal(count);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(paginationResult, HttpStatus.OK);
    }

    /**
     * 新增用户
     *
     * @param password
     * @param username
     * @param email
     * @param remark
     * @return
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + USER + "/ADD_ONE')")
    @RequestMapping(value = "/add_one", method = RequestMethod.POST)
    public ResponseEntity addOne(@RequestParam String password, @RequestParam String username, @RequestParam String email, @RequestParam Integer emailIsVerified, @RequestParam String remark) {
        UserEntity userEntity = null;
        Date date = new Date();
        try {
            userEntity = new UserEntity();
            userEntity.setPassword(password);
            userEntity.setUsername(username);
            userEntity.setEmail(email);
            userEntity.setEmailIsVerified(emailIsVerified);
            userEntity.setRemark(remark);
            userEntity.setGmtModified(date);
            userEntity.setGmtCreated(date);
            userMapper.insertOne(userEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userEntity, HttpStatus.OK);
    }

    /**
     * 保存用户
     *
     * @param id
     * @param username
     * @param email
     * @param remark
     * @return
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + USER + "/SAVE_ONE')")
    @RequestMapping(value = "/save_one", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> saveOne(@RequestParam Long id, @RequestParam String username, @RequestParam String email, @RequestParam Integer emailIsVerified, @RequestParam String remark) {
        UserEntity userEntity = null;
        Date date = new Date();
        try {
            userEntity = userMapper.getOne(id);
            userEntity.setUsername(username);
            userEntity.setEmail(email);
            userEntity.setEmailIsVerified(emailIsVerified);
            userEntity.setRemark(remark);
            userEntity.setGmtModified(date);
            userMapper.updateOne(userEntity);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userEntity, HttpStatus.OK);
    }


    /**
     * 伪删除用户
     *
     * @param idList
     * @return
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + USER + "/sign_all_gmt_deleted')")
    @RequestMapping(value = "/sign_all_gmt_deleted", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> signAllGmtDeleted(@RequestParam("id[]") List<Long> idList) {
        try {

            userService.signAllGmtDeleted(idList);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    /**
     * 撤销伪删除用户
     *
     * @param idList
     * @return
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + USER + "/unsign_all_gmt_deleted')")
    @RequestMapping(value = "/unsign_all_gmt_deleted", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> UnsignAllGmtDeleted(@RequestParam("id[]") List<Long> idList) {
        try {

            userService.unsignAllGmtDeleted(idList);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    /**
     * 指定用户 id ，批量删除用户
     *
     * @param idList
     * @return
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + USER + "/DELETE_ALL')")
    @RequestMapping(value = "/delete_all", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> deleteAll(@RequestParam("id[]") List<Long> idList) {

        int result = 0;
        try {


//                ViewMenuEntity viewMenuEntity = viewMenuMapper.getOneByMenuCategoryIdAndRoleId(id, roleId);
//                if (viewMenuEntity != null) {
//                    throw new BaseResponseException(FailureMessage.DELETE_VIEW_MENU_CATEGORY_FAIL2);
//                }

            result = userMapper.deleteAll(idList);

//
//        } catch (BaseResponseException e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(new FailureEntity(e), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 注销当前用户
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/logout", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        LOGGER.info("{}", "dddddddddddddddddd");
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null) {
                new SecurityContextLogoutHandler().logout(httpServletRequest, httpServletResponse, authentication);
            }

            //You can redirect wherever you want, but generally it's a good practice to show login screen again
            // return "redirect:" +  Page.User.LOGIN;

        } catch (Exception e) {
            e.printStackTrace();
            // 404
            return new ResponseEntity<>(new FailureEntity(FailureMessage.LOGOUT_FAIL), HttpStatus.NOT_FOUND);
        }

        // 204
        return new ResponseEntity<>(HttpStatus.OK);
    }


    /**
     * 指定用户 id ，获取用户信息（除密码和角色）
     *
     * @param id
     * @return
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + USER + "/ONE')")
    @RequestMapping(value = "/one/{id}", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> getOne(@PathVariable Long id) {
        UserEntity userEntity = null;
        try {
            userEntity = userMapper.getOne(id);
            userEntity.setPassword(null);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userEntity, HttpStatus.OK);
    }

}
