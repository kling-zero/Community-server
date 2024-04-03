package com.zeroone.star.scoauth2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

@SpringBootTest
class ScOauth2ApplicationTests {
    @Resource
    PasswordEncoder passwordEncoder;

    @Test
    void contextLoads() {
        System.out.println(passwordEncoder.encode("123456"));
    }

    void eq() {
        System.out.println("eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbImFsbCJdLCJpZCI6MSwiZXhwIjoxNjY2MzQxMjIxLCJhdXRob3JpdGllcyI6WyJTVVBFUl9BRE1JTiJdLCJqdGkiOiJmY2I4ZDM3NC1hNzNhLTRhZjUtYTkyMS1mNzhjYTI2YzRmNjkiLCJjbGllbnRfaWQiOiJzYy1tYW5hZ2VyIn0.Vg053FojB9t7imgL4kBHjgmXzasYKo_2jZcd28id1L7fXImkmU9kz2nztjJpUWDxGsti9wCvzl6zFbkcTnRDpHLArs3uLqJHCc_-6lv3SAqQCaGGubRWjb2hjDBEdIC3In6oUX-b38XUkkPWipcaGulTodY7jT4ASGI6YRT0eXVG0xs89KAUbbWtOTMPHlu3ZrcaszsR0747WDi4XSnmu72gW-NAfRDwvI-ZVmyDnljyQ1me5thc2_T6OiO9WogQNr_B1dSjGp5CSc0fFijn-xkj0xFo9-HceO2UsVb7Or-v2yX5-vhjuM4sI1uwQ05FG8YLyRBZMCr4ygm1ZGnKNA");
        System.out.println("eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbImFsbCJdLCJpZCI6MSwiZXhwIjoxNjY2MzQwMjYyLCJhdXRob3JpdGllcyI6WyJTVVBFUl9BRE1JTiJdLCJqdGkiOiIzODM5MzdjYS1kNzRhLTRmOTAtYWJmNC0wNDMzNzI0MDFhMGUiLCJjbGllbnRfaWQiOiJzYy1tYW5hZ2VyIn0.PvHTWNi6J5dPLNwFHpnqOEFfp4ObeHnPghJ3CGG0I_JMP-I9h1ok-MONLChmOlOy_T0h0XvUNyxcMqK_7eNNEkrdM5iIgbZnRymxFMOx1uTsSFm97SKWs4ccHHJSizvOCQhvXKPYDUUq3u4LfF8jiWnVBAKccMiwZFPIO3dDJHQMCZETgW2aI4_gmiuaoVp_MK005-KMhiLRsaBoLssJ8YTIwqvk5NFmoMOaK2EvLxQdcoThIM8NgdU6cKVQv0C3gFXozM2VXrBCkvaJkasaudzrBvWHYojaQyUPRL6n5wivkWmWpDOlGWobmMtOfIG3yIHJO-UZf6n_AyQVhY-S0A");
    }

}
