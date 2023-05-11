package org.gulingjingguai.mzp.dao;

import org.gulingjingguai.mzp.entity.UserInfoBo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoDao {
    UserInfoBo getUserById(int i);
}
