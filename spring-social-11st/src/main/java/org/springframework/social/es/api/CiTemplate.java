package org.springframework.social.es.api;

import org.springframework.social.es.connect.AbstractElevenStreetTemplate;
import org.springframework.web.client.RestTemplate;

/**
 * @author HyungTae Lim
 * @since 2016. 11. 1.
 */
public class CiTemplate extends AbstractElevenStreetTemplate implements Ci {
    protected CiTemplate(RestTemplate restTemplate, boolean isAuthorized) {
        super(restTemplate, isAuthorized);
    }

    @Override
    public String getBirth() {
        return null;
    }

    @Override
    public String getCi() {
        return null;
    }

    @Override
    public String getCrtfType() {
        return null;
    }

    @Override
    public String getDi() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getPhone() {
        return null;
    }

    @Override
    public String getSex() {
        return null;
    }
}
