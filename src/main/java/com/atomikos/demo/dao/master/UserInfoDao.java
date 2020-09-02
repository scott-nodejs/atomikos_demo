package com.atomikos.demo.dao.master;

import com.atomikos.demo.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserInfoDao {

    @Select({
            "<script>",
            "SELECT ",
            "id,name,age,sex",
            "FROM tb_user",
            "WHERE name = #{name,jdbcType=VARCHAR}",
            "</script>"})
    UserInfo findByUserName(@Param("name") String userName);

    @Update({
            "<script>",
            " update tb_user set",
            " name = #{name, jdbcType=VARCHAR}, age = #{age}",
            " where name=#{name}",
            "</script>"
    })
    int update(UserInfo userInfo);
}
