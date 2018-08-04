package com.gioov.spiny.system.api;

import com.gioov.common.mybatis.Pageable;
import com.gioov.common.mybatis.Sort;
import com.gioov.common.web.http.FailureEntity;
import com.gioov.spiny.common.constant.Api;
import com.gioov.spiny.common.easyui.Pagination;
import com.gioov.spiny.system.entity.EmailEntity;
import com.gioov.spiny.system.mapper.EmailMapper;
import com.gioov.spiny.system.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.gioov.spiny.user.service.UserService.SYSTEM_ADMIN;

/**
 * @author godcheese
 * @date 2018-07-08
 */
@RestController
@RequestMapping(Api.System.EMAIL)
public class EmailRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailRestController.class);

    private static final String EMAIL = "/API/SYSTEM/EMAIL";

    @Autowired
    private EmailMapper emailMapper;

    @Autowired
    private EmailService emailService;

    /**
     * 分页获取所有邮件队列
     *
     * @param page
     * @param rows
     * @return
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + EMAIL + "/PAGE_ALL_QUEUE')")
    @RequestMapping(value = "/page_all_queue", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> pageAllQueue(@RequestParam Integer page, @RequestParam Integer rows) {
        List<EmailEntity> emailEntityList = null;
        Pagination.Result<EmailEntity> paginationResult = new Pagination().new Result<>();

        Sort sort = new Sort(Sort.Direction.DESC, "gmt_created");

        try {
            emailEntityList = emailMapper.pageAll(new Pageable(page, rows, sort));
            if (emailEntityList != null) {
                paginationResult.setRows(emailEntityList);
            }
            int count = emailMapper.countAll();
            paginationResult.setTotal(count);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(paginationResult, HttpStatus.OK);
    }


    /**
     * 新增邮件
     *
     * @param from
     * @param to
     * @param subject
     * @param text
     * @param html
     * @param remark
     * @return
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + EMAIL + "/ADD_ONE')")
    @RequestMapping(value = "/add_one", method = RequestMethod.POST)
    public ResponseEntity<? extends Object> addOne(@RequestParam String from, @RequestParam String to, @RequestParam String subject, @RequestParam String text, @RequestParam Integer html, @RequestParam String remark) {
        EmailEntity emailEntity = null;
        try {
            emailEntity = new EmailEntity();
            emailEntity.setFrom(from);
            emailEntity.setTo(to);
            emailEntity.setSubject(subject);
            emailEntity.setText(text);
            emailEntity.setHtml(html);
            emailEntity.setRemark(remark);
            emailService.addQueue(emailEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(emailEntity, HttpStatus.NO_CONTENT);
    }

    /**
     * 指定邮件 id ，获取邮件信息
     *
     * @param id
     * @return
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('" + EMAIL + "/ONE')")
    @RequestMapping(value = "/one/{id}", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> getOne(@PathVariable Long id) {
        EmailEntity emailEntity = null;
        try {
            emailEntity = emailMapper.getOne(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FailureEntity(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(emailEntity, HttpStatus.OK);
    }
}
