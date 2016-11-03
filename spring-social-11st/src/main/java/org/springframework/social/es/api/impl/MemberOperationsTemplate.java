package org.springframework.social.es.api.impl;

import org.springframework.social.es.api.MemberAbout;
import org.springframework.social.es.api.MemberOperations;
import org.springframework.social.es.connect.AbstractElevenStreetTemplate;
import org.springframework.web.client.RestTemplate;

/**
 * @author HyungTae Lim
 * @since 2016. 11. 1.
 */
public class MemberOperationsTemplate extends AbstractElevenStreetTemplate implements MemberOperations {
    private static final String INFORMATION_URL = "https://stg-apis.skplanetx.com/11st/member/info";
    private static final String CI_URI = "https://stg-apis.skplanetx.com/11st/member/CIInfo";

    public MemberOperationsTemplate(RestTemplate restTemplate, boolean isAuthorized) {
        super(restTemplate, isAuthorized);
    }

    private MemberAbout getMemberAbout(String url) {
        return getEntity(url, MemberAbout.class);
    }

    @Override
    public MemberAbout.Information getMemberInformation() {
        return getMemberAbout(INFORMATION_URL).getInformation();
    }

    @Override
    public MemberAbout.Ci getMemberCi() {
        return getMemberAbout(CI_URI).getCi();
    }
}
