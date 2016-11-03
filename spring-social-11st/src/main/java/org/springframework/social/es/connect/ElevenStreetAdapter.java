package org.springframework.social.es.connect;

import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.es.api.ElevenStreet;
import org.springframework.social.es.api.MemberAbout;
import org.springframework.social.es.api.MemberOperations;

/**
 * @author HyungTae Lim
 * @since 2016. 11. 1.
 */
public class ElevenStreetAdapter implements ApiAdapter<ElevenStreet> {

    @Override
    public boolean test(ElevenStreet elevenStreet) {
        try {
            elevenStreet.getMemberOperations();
            return true;
        } catch (ApiException e) {
            return false;
        }
    }

    @Override
    public void setConnectionValues(ElevenStreet elevenStreet, ConnectionValues values) {
        final MemberAbout.Information memberInformation = elevenStreet.getMemberOperations().getMemberInformation();
        final MemberAbout.Ci memberCi = elevenStreet.getMemberOperations().getMemberCi();
        values.setProviderUserId(memberInformation.getMemNm());
        values.setDisplayName(memberCi.getName());
    }

    @Override
    public UserProfile fetchUserProfile(ElevenStreet elevenStreet) {
        final MemberAbout.Information memberInformation = elevenStreet.getMemberOperations().getMemberInformation();
        final MemberAbout.Ci memberCi = elevenStreet.getMemberOperations().getMemberCi();
        return new UserProfileBuilder()
                .setUsername(memberInformation.getMemId())
                .setId(memberInformation.getMemNo())
                .setEmail(memberInformation.getEmail())
                .setName(memberCi.getName())
                .setFirstName(memberCi.getFirstName())
                .setLastName(memberCi.getLastName()).build();
    }

    @Override
    public void updateStatus(ElevenStreet elevenStreet, String message) {
        throw new UnsupportedOperationException();
    }
}