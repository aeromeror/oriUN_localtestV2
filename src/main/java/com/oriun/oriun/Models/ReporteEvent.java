package com.oriun.oriun.Models;

import java.sql.Date;
import java.sql.Time;

public interface ReporteEvent {
    Integer getID_EVENT();
    String getUSER_NAME();
    String getNAME_LOC_SPORT();
    String getNAME_SPORT();
    String getEVENT_DESCRIPTION();
    Date getEVENT_INIT();
    Date getEVENT_END();
    double getCAPACITY();
    String getOTHER_SPORT();
    Time getEVENT_INIT_HOUR();
    Time getEVENT_FINISH_HOUR();
    String getEVENT_TITLE();
    Date getCREATION_DATE();
    long getCount();
}
