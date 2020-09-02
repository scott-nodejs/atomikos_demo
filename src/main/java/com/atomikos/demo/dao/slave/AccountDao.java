package com.atomikos.demo.dao.slave;

import com.atomikos.demo.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AccountDao {
    @Select({
            "<script>",
            "SELECT ",
            "id,user_id,account",
            "FROM tb_account",
            "WHERE user_id = #{id,jdbcType=VARCHAR}",
            "</script>"})
    Account findByUserId(@Param("id") int id);

    @Update({
            "<script>",
            " update tb_account set",
            " account = #{account, jdbcType=VARCHAR}",
            " where user_id=#{userId}",
            "</script>"
    })
    int update(Account account);
}
