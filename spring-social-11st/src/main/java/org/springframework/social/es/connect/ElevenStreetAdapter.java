package org.springframework.social.es.connect;

import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.es.api.ElevenStreet;
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
        final MemberOperations memberOperations = elevenStreet.getMemberOperations();
        values.setProviderUserId(memberOperations.getMemberInformation().getMemNm());
        values.setDisplayName(memberOperations.getMemberCi().getName());
    }

    @Override
    public UserProfile fetchUserProfile(ElevenStreet elevenStreet) {
        final MemberOperations memberOperations = elevenStreet.getMemberOperations();
        return new UserProfileBuilder()
                .setUsername(memberOperations.getMemberInformation().getMemId())
                .setId(memberOperations.getMemberInformation().getMemNo())
                .setEmail(memberOperations.getMemberInformation().getEmail())
                .setName(memberOperations.getMemberCi().getName())
                .setFirstName(memberOperations.getMemberCi().getFirstName())
                .setLastName(memberOperations.getMemberCi().getLastName()).build();
    }

    @Override
    public void updateStatus(ElevenStreet elevenStreet, String message) {
        throw new UnsupportedOperationException();
    }
}