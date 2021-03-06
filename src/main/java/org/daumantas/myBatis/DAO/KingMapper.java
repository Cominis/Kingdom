package org.daumantas.myBatis.DAO;

import java.util.List;
import org.daumantas.myBatis.model.King;
import org.mybatis.cdi.Mapper;

@Mapper
public interface KingMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.KING
     *
     * @mbg.generated Thu Apr 01 11:11:56 EEST 2021
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.KING
     *
     * @mbg.generated Thu Apr 01 11:11:56 EEST 2021
     */
    int insert(King record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.KING
     *
     * @mbg.generated Thu Apr 01 11:11:56 EEST 2021
     */
    King selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.KING
     *
     * @mbg.generated Thu Apr 01 11:11:56 EEST 2021
     */
    List<King> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.KING
     *
     * @mbg.generated Thu Apr 01 11:11:56 EEST 2021
     */
    int updateByPrimaryKey(King record);
}