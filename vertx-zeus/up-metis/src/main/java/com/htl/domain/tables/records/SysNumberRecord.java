/*
 * This file is generated by jOOQ.
*/
package com.htl.domain.tables.records;


import com.htl.domain.tables.SysNumber;
import com.htl.domain.tables.interfaces.ISysNumber;

import java.time.LocalDateTime;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record20;
import org.jooq.Row20;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SysNumberRecord extends UpdatableRecordImpl<SysNumberRecord> implements Record20<String, Long, String, String, String, String, String, String, String, String, Integer, Integer, Boolean, Boolean, String, String, String, LocalDateTime, String, LocalDateTime>, ISysNumber {

    private static final long serialVersionUID = -372946910;

    /**
     * Setter for <code>DB_HTL.SYS_NUMBER.PK_ID</code>. uniqueId,PK_ID
     */
    @Override
    public SysNumberRecord setPkId(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>DB_HTL.SYS_NUMBER.PK_ID</code>. uniqueId,PK_ID
     */
    @Override
    public String getPkId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>DB_HTL.SYS_NUMBER.L_CURRENT</code>. 编号当前值，对应${seed}，每次变化时current提取后更新为：current + step或current - step,current,L_CURRENT
     */
    @Override
    public SysNumberRecord setLCurrent(Long value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>DB_HTL.SYS_NUMBER.L_CURRENT</code>. 编号当前值，对应${seed}，每次变化时current提取后更新为：current + step或current - step,current,L_CURRENT
     */
    @Override
    public Long getLCurrent() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>DB_HTL.SYS_NUMBER.S_CODE</code>. code,S_CODE
     */
    @Override
    public SysNumberRecord setSCode(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>DB_HTL.SYS_NUMBER.S_CODE</code>. code,S_CODE
     */
    @Override
    public String getSCode() {
        return (String) get(2);
    }

    /**
     * Setter for <code>DB_HTL.SYS_NUMBER.S_COMMENT</code>. 编号备注信息，用于描述编号数据,comment,S_COMMENT
     */
    @Override
    public SysNumberRecord setSComment(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>DB_HTL.SYS_NUMBER.S_COMMENT</code>. 编号备注信息，用于描述编号数据,comment,S_COMMENT
     */
    @Override
    public String getSComment() {
        return (String) get(3);
    }

    /**
     * Setter for <code>DB_HTL.SYS_NUMBER.S_FORMAT</code>. 格式信息，用于处理最终格式：,format,S_FORMAT
     */
    @Override
    public SysNumberRecord setSFormat(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>DB_HTL.SYS_NUMBER.S_FORMAT</code>. 格式信息，用于处理最终格式：,format,S_FORMAT
     */
    @Override
    public String getSFormat() {
        return (String) get(4);
    }

    /**
     * Setter for <code>DB_HTL.SYS_NUMBER.S_IDENTIFIER</code>. 编号对应的identifier，用于查询当前identifier使用的序号信息,identifier,S_IDENTIFIER
     */
    @Override
    public SysNumberRecord setSIdentifier(String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>DB_HTL.SYS_NUMBER.S_IDENTIFIER</code>. 编号对应的identifier，用于查询当前identifier使用的序号信息,identifier,S_IDENTIFIER
     */
    @Override
    public String getSIdentifier() {
        return (String) get(5);
    }

    /**
     * Setter for <code>DB_HTL.SYS_NUMBER.S_PREFIX</code>. 编号前缀,prefix,S_PREFIX
     */
    @Override
    public SysNumberRecord setSPrefix(String value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>DB_HTL.SYS_NUMBER.S_PREFIX</code>. 编号前缀,prefix,S_PREFIX
     */
    @Override
    public String getSPrefix() {
        return (String) get(6);
    }

    /**
     * Setter for <code>DB_HTL.SYS_NUMBER.S_SUFFIX</code>. 编号后缀,suffix,S_SUFFIX
     */
    @Override
    public SysNumberRecord setSSuffix(String value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>DB_HTL.SYS_NUMBER.S_SUFFIX</code>. 编号后缀,suffix,S_SUFFIX
     */
    @Override
    public String getSSuffix() {
        return (String) get(7);
    }

    /**
     * Setter for <code>DB_HTL.SYS_NUMBER.S_TIME</code>. 时间对应Pattern，对应${time}：YYYY-MM-DD HH:mm:ss用于描述时间格式生成序号时间部分,time,S_TIME
     */
    @Override
    public SysNumberRecord setSTime(String value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>DB_HTL.SYS_NUMBER.S_TIME</code>. 时间对应Pattern，对应${time}：YYYY-MM-DD HH:mm:ss用于描述时间格式生成序号时间部分,time,S_TIME
     */
    @Override
    public String getSTime() {
        return (String) get(8);
    }

    /**
     * Setter for <code>DB_HTL.SYS_NUMBER.J_CONFIG</code>. config,J_CONFIG
     */
    @Override
    public SysNumberRecord setJConfig(String value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>DB_HTL.SYS_NUMBER.J_CONFIG</code>. config,J_CONFIG
     */
    @Override
    public String getJConfig() {
        return (String) get(9);
    }

    /**
     * Setter for <code>DB_HTL.SYS_NUMBER.I_LENGTH</code>. 编号长度，编号长度不包含prefix和suffix部分,length,I_LENGTH
     */
    @Override
    public SysNumberRecord setILength(Integer value) {
        set(10, value);
        return this;
    }

    /**
     * Getter for <code>DB_HTL.SYS_NUMBER.I_LENGTH</code>. 编号长度，编号长度不包含prefix和suffix部分,length,I_LENGTH
     */
    @Override
    public Integer getILength() {
        return (Integer) get(10);
    }

    /**
     * Setter for <code>DB_HTL.SYS_NUMBER.I_STEP</code>. 编号的步进系数，每次按照step进行变化,step,I_STEP
     */
    @Override
    public SysNumberRecord setIStep(Integer value) {
        set(11, value);
        return this;
    }

    /**
     * Getter for <code>DB_HTL.SYS_NUMBER.I_STEP</code>. 编号的步进系数，每次按照step进行变化,step,I_STEP
     */
    @Override
    public Integer getIStep() {
        return (Integer) get(11);
    }

    /**
     * Setter for <code>DB_HTL.SYS_NUMBER.IS_DECREMENT</code>. 递增/递减？如果为true则递减，为false则是递增,decrement,IS_DECREMENT
     */
    @Override
    public SysNumberRecord setIsDecrement(Boolean value) {
        set(12, value);
        return this;
    }

    /**
     * Getter for <code>DB_HTL.SYS_NUMBER.IS_DECREMENT</code>. 递增/递减？如果为true则递减，为false则是递增,decrement,IS_DECREMENT
     */
    @Override
    public Boolean getIsDecrement() {
        return (Boolean) get(12);
    }

    /**
     * Setter for <code>DB_HTL.SYS_NUMBER.IS_ACTIVE</code>. active,IS_ACTIVE
     */
    @Override
    public SysNumberRecord setIsActive(Boolean value) {
        set(13, value);
        return this;
    }

    /**
     * Getter for <code>DB_HTL.SYS_NUMBER.IS_ACTIVE</code>. active,IS_ACTIVE
     */
    @Override
    public Boolean getIsActive() {
        return (Boolean) get(13);
    }

    /**
     * Setter for <code>DB_HTL.SYS_NUMBER.Z_SIGMA</code>. sigma,Z_SIGMA
     */
    @Override
    public SysNumberRecord setZSigma(String value) {
        set(14, value);
        return this;
    }

    /**
     * Getter for <code>DB_HTL.SYS_NUMBER.Z_SIGMA</code>. sigma,Z_SIGMA
     */
    @Override
    public String getZSigma() {
        return (String) get(14);
    }

    /**
     * Setter for <code>DB_HTL.SYS_NUMBER.Z_LANGUAGE</code>. language,Z_LANGUAGE
     */
    @Override
    public SysNumberRecord setZLanguage(String value) {
        set(15, value);
        return this;
    }

    /**
     * Getter for <code>DB_HTL.SYS_NUMBER.Z_LANGUAGE</code>. language,Z_LANGUAGE
     */
    @Override
    public String getZLanguage() {
        return (String) get(15);
    }

    /**
     * Setter for <code>DB_HTL.SYS_NUMBER.Z_CREATE_BY</code>. createBy,Z_CREATE_BY
     */
    @Override
    public SysNumberRecord setZCreateBy(String value) {
        set(16, value);
        return this;
    }

    /**
     * Getter for <code>DB_HTL.SYS_NUMBER.Z_CREATE_BY</code>. createBy,Z_CREATE_BY
     */
    @Override
    public String getZCreateBy() {
        return (String) get(16);
    }

    /**
     * Setter for <code>DB_HTL.SYS_NUMBER.Z_CREATE_TIME</code>. createTime,Z_CREATE_TIME
     */
    @Override
    public SysNumberRecord setZCreateTime(LocalDateTime value) {
        set(17, value);
        return this;
    }

    /**
     * Getter for <code>DB_HTL.SYS_NUMBER.Z_CREATE_TIME</code>. createTime,Z_CREATE_TIME
     */
    @Override
    public LocalDateTime getZCreateTime() {
        return (LocalDateTime) get(17);
    }

    /**
     * Setter for <code>DB_HTL.SYS_NUMBER.Z_UPDATE_BY</code>. updateBy,Z_UPDATE_BY
     */
    @Override
    public SysNumberRecord setZUpdateBy(String value) {
        set(18, value);
        return this;
    }

    /**
     * Getter for <code>DB_HTL.SYS_NUMBER.Z_UPDATE_BY</code>. updateBy,Z_UPDATE_BY
     */
    @Override
    public String getZUpdateBy() {
        return (String) get(18);
    }

    /**
     * Setter for <code>DB_HTL.SYS_NUMBER.Z_UPDATE_TIME</code>. updateTime,Z_UPDATE_TIME
     */
    @Override
    public SysNumberRecord setZUpdateTime(LocalDateTime value) {
        set(19, value);
        return this;
    }

    /**
     * Getter for <code>DB_HTL.SYS_NUMBER.Z_UPDATE_TIME</code>. updateTime,Z_UPDATE_TIME
     */
    @Override
    public LocalDateTime getZUpdateTime() {
        return (LocalDateTime) get(19);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record20 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row20<String, Long, String, String, String, String, String, String, String, String, Integer, Integer, Boolean, Boolean, String, String, String, LocalDateTime, String, LocalDateTime> fieldsRow() {
        return (Row20) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row20<String, Long, String, String, String, String, String, String, String, String, Integer, Integer, Boolean, Boolean, String, String, String, LocalDateTime, String, LocalDateTime> valuesRow() {
        return (Row20) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return SysNumber.SYS_NUMBER.PK_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return SysNumber.SYS_NUMBER.L_CURRENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return SysNumber.SYS_NUMBER.S_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return SysNumber.SYS_NUMBER.S_COMMENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return SysNumber.SYS_NUMBER.S_FORMAT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return SysNumber.SYS_NUMBER.S_IDENTIFIER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return SysNumber.SYS_NUMBER.S_PREFIX;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return SysNumber.SYS_NUMBER.S_SUFFIX;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return SysNumber.SYS_NUMBER.S_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field10() {
        return SysNumber.SYS_NUMBER.J_CONFIG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field11() {
        return SysNumber.SYS_NUMBER.I_LENGTH;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field12() {
        return SysNumber.SYS_NUMBER.I_STEP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field13() {
        return SysNumber.SYS_NUMBER.IS_DECREMENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field14() {
        return SysNumber.SYS_NUMBER.IS_ACTIVE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field15() {
        return SysNumber.SYS_NUMBER.Z_SIGMA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field16() {
        return SysNumber.SYS_NUMBER.Z_LANGUAGE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field17() {
        return SysNumber.SYS_NUMBER.Z_CREATE_BY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<LocalDateTime> field18() {
        return SysNumber.SYS_NUMBER.Z_CREATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field19() {
        return SysNumber.SYS_NUMBER.Z_UPDATE_BY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<LocalDateTime> field20() {
        return SysNumber.SYS_NUMBER.Z_UPDATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getPkId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component2() {
        return getLCurrent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getSCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getSComment();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getSFormat();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getSIdentifier();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getSPrefix();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component8() {
        return getSSuffix();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component9() {
        return getSTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component10() {
        return getJConfig();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component11() {
        return getILength();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component12() {
        return getIStep();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean component13() {
        return getIsDecrement();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean component14() {
        return getIsActive();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component15() {
        return getZSigma();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component16() {
        return getZLanguage();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component17() {
        return getZCreateBy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime component18() {
        return getZCreateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component19() {
        return getZUpdateBy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime component20() {
        return getZUpdateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getPkId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value2() {
        return getLCurrent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getSCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getSComment();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getSFormat();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getSIdentifier();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getSPrefix();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getSSuffix();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getSTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value10() {
        return getJConfig();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value11() {
        return getILength();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value12() {
        return getIStep();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value13() {
        return getIsDecrement();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value14() {
        return getIsActive();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value15() {
        return getZSigma();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value16() {
        return getZLanguage();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value17() {
        return getZCreateBy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime value18() {
        return getZCreateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value19() {
        return getZUpdateBy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime value20() {
        return getZUpdateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysNumberRecord value1(String value) {
        setPkId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysNumberRecord value2(Long value) {
        setLCurrent(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysNumberRecord value3(String value) {
        setSCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysNumberRecord value4(String value) {
        setSComment(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysNumberRecord value5(String value) {
        setSFormat(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysNumberRecord value6(String value) {
        setSIdentifier(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysNumberRecord value7(String value) {
        setSPrefix(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysNumberRecord value8(String value) {
        setSSuffix(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysNumberRecord value9(String value) {
        setSTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysNumberRecord value10(String value) {
        setJConfig(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysNumberRecord value11(Integer value) {
        setILength(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysNumberRecord value12(Integer value) {
        setIStep(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysNumberRecord value13(Boolean value) {
        setIsDecrement(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysNumberRecord value14(Boolean value) {
        setIsActive(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysNumberRecord value15(String value) {
        setZSigma(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysNumberRecord value16(String value) {
        setZLanguage(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysNumberRecord value17(String value) {
        setZCreateBy(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysNumberRecord value18(LocalDateTime value) {
        setZCreateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysNumberRecord value19(String value) {
        setZUpdateBy(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysNumberRecord value20(LocalDateTime value) {
        setZUpdateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysNumberRecord values(String value1, Long value2, String value3, String value4, String value5, String value6, String value7, String value8, String value9, String value10, Integer value11, Integer value12, Boolean value13, Boolean value14, String value15, String value16, String value17, LocalDateTime value18, String value19, LocalDateTime value20) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        value16(value16);
        value17(value17);
        value18(value18);
        value19(value19);
        value20(value20);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public void from(ISysNumber from) {
        setPkId(from.getPkId());
        setLCurrent(from.getLCurrent());
        setSCode(from.getSCode());
        setSComment(from.getSComment());
        setSFormat(from.getSFormat());
        setSIdentifier(from.getSIdentifier());
        setSPrefix(from.getSPrefix());
        setSSuffix(from.getSSuffix());
        setSTime(from.getSTime());
        setJConfig(from.getJConfig());
        setILength(from.getILength());
        setIStep(from.getIStep());
        setIsDecrement(from.getIsDecrement());
        setIsActive(from.getIsActive());
        setZSigma(from.getZSigma());
        setZLanguage(from.getZLanguage());
        setZCreateBy(from.getZCreateBy());
        setZCreateTime(from.getZCreateTime());
        setZUpdateBy(from.getZUpdateBy());
        setZUpdateTime(from.getZUpdateTime());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends ISysNumber> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SysNumberRecord
     */
    public SysNumberRecord() {
        super(SysNumber.SYS_NUMBER);
    }

    /**
     * Create a detached, initialised SysNumberRecord
     */
    public SysNumberRecord(String pkId, Long lCurrent, String sCode, String sComment, String sFormat, String sIdentifier, String sPrefix, String sSuffix, String sTime, String jConfig, Integer iLength, Integer iStep, Boolean isDecrement, Boolean isActive, String zSigma, String zLanguage, String zCreateBy, LocalDateTime zCreateTime, String zUpdateBy, LocalDateTime zUpdateTime) {
        super(SysNumber.SYS_NUMBER);

        set(0, pkId);
        set(1, lCurrent);
        set(2, sCode);
        set(3, sComment);
        set(4, sFormat);
        set(5, sIdentifier);
        set(6, sPrefix);
        set(7, sSuffix);
        set(8, sTime);
        set(9, jConfig);
        set(10, iLength);
        set(11, iStep);
        set(12, isDecrement);
        set(13, isActive);
        set(14, zSigma);
        set(15, zLanguage);
        set(16, zCreateBy);
        set(17, zCreateTime);
        set(18, zUpdateBy);
        set(19, zUpdateTime);
    }
}