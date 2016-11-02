package org.springframework.social.es.api;

import org.springframework.social.es.connect.AbstractElevenStreetTemplate;
import org.springframework.web.client.RestTemplate;

/**
 * @author HyungTae Lim
 * @since 2016. 11. 1.
 */
public class MemberTemplate extends AbstractElevenStreetTemplate implements Member {
    private static final String INFORMATION_URL = "https://stg-apis.skplanetx.com/11st/member/info";
    private static final String CI_URI = "https://stg-apis.skplanetx.com/11st/member/CIInfo";

    public MemberTemplate(RestTemplate restTemplate, boolean isAuthorized) {
        super(restTemplate, isAuthorized);
    }

    @Override
    public Information getInformation() {
        return getEntity(INFORMATION_URL, Information.class);
    }

    @Override
    public Ci getCi() {
        return getEntity(CI_URI, Ci.class);
    }
}
