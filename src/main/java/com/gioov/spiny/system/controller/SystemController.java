package com.gioov.spiny.system.controller;

import com.gioov.spiny.common.annotation.loggingoperation.LoggingOperation;
import com.gioov.spiny.common.constant.Page;
import com.gioov.spiny.common.property.AppProperties;
import com.gioov.spiny.system.entity.EmailEntity;
import com.gioov.spiny.system.service.DictionaryService;
import com.gioov.spiny.system.service.EmailService;
import com.gioov.spiny.user.mapper.ViewMenuCategoryMapper;
import com.gioov.spiny.user.mapper.ViewMenuMapper;
import com.gioov.spiny.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static com.gioov.spiny.common.constant.Page.INDEX;
import static com.gioov.spiny.user.service.UserService.SYSTEM_ADMIN;

/**
 * @author godcheese
 */
@Controller
@RequestMapping
public class SystemController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SystemController.class);

    @Value("${server.error.path}")
    private String serverErrorPath;

    @Autowired
    private ViewMenuCategoryMapper viewMenuCategoryMapper;

    @Autowired
    private AppProperties appProperties;

    @Autowired
    private ViewMenuMapper viewMenuMapper;

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private UserService userService;

    @Autowired
    EmailService emailService;

    /**
     * 用户登录后首页
     *
     * @param httpServletRequest
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/test")
    public ResponseEntity<String> test(HttpServletRequest httpServletRequest, ModelAndView modelAndView) {

//        String host = "smtp.exmail.qq.com";
//        String protocol = "smtp";
//        int port = 25;
//        String username = "no-reply@example.com";
//        String password = "1i7efzx0AAGk";
//        String from = "no-reply@example.com";
//        String to = "1176394803@qq.com";
//
//        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
//        javaMailSender.setHost(host);
//        javaMailSender.setProtocol(protocol);
//        javaMailSender.setPort(port);
//        javaMailSender.setUsername(username);
//        javaMailSender.setPassword(password);
//
//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
//
//        String subject = "test";
//        String text = "测试";
//        boolean html = false;
//        try {
//
//            mimeMessageHelper.setFrom(from);
//            mimeMessageHelper.setTo(to);
//            mimeMessage.setSubject(subject);
//            mimeMessageHelper.setText(text, html);
//            javaMailSender.send(mimeMessage);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }

        EmailEntity emailEntity = new EmailEntity();
        emailEntity.setTo("godcheese@qq.com");
        emailEntity.setSubject("2");
        emailEntity.setText("TESTT1111TT");
        emailEntity.setHtml(0);
//        try {
//            emailService.send(emailEntity);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//

        emailService.addQueue(emailEntity);
//        try {
//            EmailQueue.getEmailQueue().produce(emailEntity);
//            LOGGER.info("test11111111111111111111111111111111111111111111111");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        try {
//            EmailQueue.getQueue().produce().sendMimeMailMessage("godcheese@qq.com", "test", "testtext11111111", true);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//        modelAndView.setViewName(Page.SYSTEM + "/test");
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    /**
     * 用户登录后首页
     *
     * @param httpServletRequest
     * @param modelAndView
     * @return
     */
    @LoggingOperation("访问首页")
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAnyAuthority('/','/INDEX','/SYSTEM','/SYSTEM/INDEX')")
    @RequestMapping(value = {"/", INDEX, Page.SYSTEM, Page.System.INDEX})
    public ModelAndView index(HttpServletRequest httpServletRequest, ModelAndView modelAndView) {
//        dictionaryService.modelAndViewAddDictionary(modelAndView, DictionaryConstant.SYSTEM, DictionaryConstant.WEB_FOOTER);

        modelAndView.setViewName(Page.SYSTEM + "/index");
        return modelAndView;
    }

    /**
     * 工作台
     *
     * @return
     */
    @PreAuthorize("hasRole('" + SYSTEM_ADMIN + "') OR hasAuthority('/SYSTEM/WORKBENCH')")
    @RequestMapping(value = Page.System.WORKBENCH)
    public String workbench() {
        return Page.System.WORKBENCH;
    }

}
