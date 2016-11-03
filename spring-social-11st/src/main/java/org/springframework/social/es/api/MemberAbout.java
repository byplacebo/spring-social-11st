package org.springframework.social.es.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author HyungTae Lim
 * @since 2016. 11. 3.
 */
public class MemberAbout {
    @JsonProperty("CIInfo")
    private Ci ci;

    @JsonProperty("MemberInfo")
    private Information information;

    public Ci getCi() {
        return ci;
    }

    public Information getInformation() {
        return information;
    }

    public static class Ci {
        private String birth;
        private String ci;
        private String crtfType;
        private String di;
        private String name;
        private String phone;
        private String sex;

        public String getFirstName() {
            return null;
        }
        public String getLastName() {
            return null;
        }

        public String getName() {
            return name;
        }

        public String getBirth() {
            return birth;
        }

        public String getCi() {
            return ci;
        }

        public String getCrtfType() {
            return crtfType;
        }

        public String getDi() {
            return di;
        }

        public String getPhone() {
            return phone;
        }

        public String getSex() {
            return sex;
        }
    }

    public static class Information {
        private String email;
        private String memId;
        private String memNm;
        private String memNo;
        private String phone;

        public String getEmail() {
            return email;
        }

        public String getMemId() {
            return memId;
        }

        public String getMemNm() {
            return memNm;
        }

        public String getMemNo() {
            return memNo;
        }

        public String getPhone() {
            return phone;
        }
    }


}
