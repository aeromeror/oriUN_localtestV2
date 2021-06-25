package com.oriun.oriun.Models;

import java.sql.Date;
import java.sql.Time;

public interface AlqElem {
    Date getRENT_DATE();
    Time getRENT_TIME();
    Time getRENT_DURATION();
    int getID_RENT();
    String getUSER_NAME();
    int getID_ELEMENT();
    String getNAME_LOCATION();
    String getNAME_SPORT();
    String getDESCRIPTION();
    boolean isAVAILABLE();
    String getELEMENT_NAME();
    byte[] getELEMENT_IMAGE();
}
