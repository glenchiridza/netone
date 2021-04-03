/**
 * Created by glenc on Apr 2021
 **/

package com.glencconnnect.net1.models;

public class MyCodes {
    private String codeTitle;
    private String codeNum;

    public MyCodes(String codeTitle, String codeNum) {
        this.codeTitle = codeTitle;
        this.codeNum = codeNum;
    }

    public String getCodeTitle() {
        return codeTitle;
    }

    public void setCodeTitle(String codeTitle) {
        this.codeTitle = codeTitle;
    }

    public String getCodeNum() {
        return codeNum;
    }

    public void setCodeNum(String codeNum) {
        this.codeNum = codeNum;
    }
}


