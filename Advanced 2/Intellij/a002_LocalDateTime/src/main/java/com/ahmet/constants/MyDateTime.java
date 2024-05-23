package com.ahmet.constants;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class MyDateTime {

    private static Long SANIYE = 1000L;

    public static final Long DAKIKA = SANIYE * 60;
    public static final Long SAAT = DAKIKA * 60;
    public static final Long GUN = SAAT * 24;
    public static final Long YEDIGUN = GUN * 7;

    //METHODS:
    public static LocalDateTime getCurrentTime() {
        return ZonedDateTime.now(ZoneId.of("Europe/Istanbul")).toLocalDateTime();
    }
}
