package org.daumantas.myBatis.model;

public class King {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.KING.ID
     *
     * @mbg.generated Thu Apr 01 11:11:56 EEST 2021
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.KING.NAME
     *
     * @mbg.generated Thu Apr 01 11:11:56 EEST 2021
     */
    private String name;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.KING.ID
     *
     * @return the value of PUBLIC.KING.ID
     *
     * @mbg.generated Thu Apr 01 11:11:56 EEST 2021
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.KING.ID
     *
     * @param id the value for PUBLIC.KING.ID
     *
     * @mbg.generated Thu Apr 01 11:11:56 EEST 2021
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.KING.NAME
     *
     * @return the value of PUBLIC.KING.NAME
     *
     * @mbg.generated Thu Apr 01 11:11:56 EEST 2021
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.KING.NAME
     *
     * @param name the value for PUBLIC.KING.NAME
     *
     * @mbg.generated Thu Apr 01 11:11:56 EEST 2021
     */
    public void setName(String name) {
        this.name = name;
    }
}