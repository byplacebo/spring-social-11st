package org.springframework.social.es.connect;

import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.es.api.ElevenStreet;
import org.springframework.social.es.api.MemberAbout;

import java.util.Optional;

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
        final Optional<MemberAbout.Information> memberInformation = elevenStreet.getMemberOperations().getMemberInformation();
        final Optional<MemberAbout.Ci> memberCi = elevenStreet.getMemberOperations().getMemberCi();
        if (memberInformation.isPresent() && memberCi.isPresent()) {
            values.setProviderUserId(memberInformation.get().getMemNm());
            values.setDisplayName(memberCi.get().getName());
        }
    }

    @Override
    public UserProfile fetchUserProfile(ElevenStreet elevenStreet) {
        final Optional<MemberAbout.Information> memberInformation = elevenStreet.getMemberOperations().getMemberInformation();
        final Optional<MemberAbout.Ci> memberCi = elevenStreet.getMemberOperations().getMemberCi();
        if (memberInformation.isPresent() && memberCi.isPresent()) {
            return new UserProfileBuilder()
                    .setUsername(memberInformation.get().getMemId())
                    .setId(memberInformation.get().getMemNo())
                    .setEmail(memberInformation.get().getEmail())
                    .setName(memberCi.get().getName())
                    .setFirstName(memberCi.get().getFirstName())
                    .setLastName(memberCi.get().getLastName()).build();
        }
        else {
            return null;
        }

    }

    @Override
    public void updateStatus(ElevenStreet elevenStreet, String message) {
        throw new UnsupportedOperationException();
    }
}