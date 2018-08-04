package com.gioov.spiny.user.service;

import com.gioov.spiny.common.security.SimpleUser;
import com.gioov.spiny.user.entity.UserEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author godcheese
 * @date 2018/3/7 14:17
 */
public interface UserService {

    String SYSTEM_ADMIN = "SYSTEM_ADMIN";

    UserEntity getOneByIdAndPassword(Long id, String password);

    UserEntity getOneByUsernameAndPassword(String username, String password);

    UserEntity getOneByEmailAndPassword(String email, String password);

    UserEntity getOneByCellphoneAndPassword(String cellphone, String password);

    boolean checkPassword(String plainPassword, String cipherPassword);

    String encodePassword(String plainPassword);

    SimpleUser getUserPrincipal(HttpServletRequest request);

    UserEntity getOneByIdNoPassword(Long id);

    void signAllGmtDeleted(List<Long> idList);

    void unsignAllGmtDeleted(List<Long> idList);

    /**
     * 可能会 null
     *
     * @return
     */
    UserEntity getCurrentUser();

    /**
     * 更可靠的获取
     *
     * @param request
     * @return
     */
    UserEntity getCurrentUser(HttpServletRequest request);
}



