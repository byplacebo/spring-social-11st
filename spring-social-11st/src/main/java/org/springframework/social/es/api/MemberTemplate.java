package org.springframework.social.es.api;

import org.springframework.social.es.connect.AbstractElevenStreetTemplate;
import org.springframework.web.client.RestTemplate;

/**
 * @author HyungTae Lim
 * @since 2016. 11. 1.
 */
public class MemberTemplate extends AbstractElevenStreetTemplate implements Member {

    public MemberTemplate(RestTemplate restTemplate, boolean isAuthorized) {
        super(restTemplate, isAuthorized);
    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public String getMemId() {
        return null;
    }

    @Override
    public String getMemNm() {
        return null;
    }

    @Override
    public String getMemNo() {
        return null;
    }

    @Override
    public String getPhone() {
        return null;
    }
}
