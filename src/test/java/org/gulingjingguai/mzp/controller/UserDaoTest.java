package org.gulingjingguai.mzp.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.gulingjingguai.mzp.dao.UserInfoDao;
import org.gulingjingguai.mzp.entity.UserInfoBo;
import org.junit.Before;
import org.junit.Test;

public class UserDaoTest {
    private UserInfoDao userDao;
    private UserInfoBo user;

    @Before
    public void setUp() {
        userDao = mock(UserInfoDao.class);
        user = new UserInfoBo("John", "123456");
        when(userDao.getUserById(1)).thenReturn(user);
    }

    @Test
    public void testGetUserById() {
        UserInfoBo retrievedUser = userDao.getUserById(1);
        assertEquals(user, retrievedUser);
    }
}