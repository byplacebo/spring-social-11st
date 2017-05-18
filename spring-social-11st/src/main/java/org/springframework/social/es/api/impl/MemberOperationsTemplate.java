package org.springframework.social.es.api.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.es.api.MemberAbout;
import org.springframework.social.es.api.MemberOperations;
import org.springframework.social.es.connect.AbstractElevenStreetTemplate;
import org.springframework.social.es.connect.ElevenStreetServiceProvider;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

/**
 * @author HyungTae Lim
 * @since 2016. 11. 1.
 */
public class MemberOperationsTemplate extends AbstractElevenStreetTemplate implements MemberOperations {
    private static final Logger log = LoggerFactory.getLogger(MemberOperationsTemplate.class);

    private static final String INFORMATION_URL = "/11st/member/info";
    private static final String CI_URI = "/11st/member/CIInfo";

    public MemberOperationsTemplate(RestTemplate restTemplate, boolean isAuthorized) {
        super(restTemplate, isAuthorized);
    }

    private Optional<MemberAbout> getMemberAbout(String url) {
        try {
            return Optional.ofNullable(getEntity(url, MemberAbout.class));
        } catch (Exception e) {
            log.error("", e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<MemberAbout.Information> getMemberInformation() {
        try {
            final Optional<MemberAbout> memberAbout = getMemberAbout(ElevenStreetServiceProvider.getUrl() + INFORMATION_URL);
            if (memberAbout.isPresent()) {
                return Optional.ofNullable(memberAbout.get().getInformation());
            }
        } catch (Exception e) {
            log.error("", e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<MemberAbout.Ci> getMemberCi() {
        try {
            final Optional<MemberAbout> memberAbout = getMemberAbout(ElevenStreetServiceProvider.getUrl() + CI_URI);
            if (memberAbout.isPresent()) {
                return Optional.ofNullable(memberAbout.get().getCi());
            }
        } catch (Exception e) {
            log.error("", e);
        }
        return Optional.empty();
    }
}
