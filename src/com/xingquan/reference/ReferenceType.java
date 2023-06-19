package com.xingquan.reference;

import java.lang.ref.Reference;

/**
 * 引用的枚举
 *
 * @author xingquan
 * @created 2019-05-28 22:59:00
 */
public enum ReferenceType {

    /**
     * 软引用
     */
    SOFT_REFERENCE(1),

    /**
     * 弱引用
     */
    WEAK_REFERENCE(2),

    /**
     * 幻象引用
     */
    PHANTOM_REFERENCE(3)


    ;

    private int code;

    public int getCode() {
        return code;
    }

    ReferenceType(int code) {
        this.code = code;
    }

}
