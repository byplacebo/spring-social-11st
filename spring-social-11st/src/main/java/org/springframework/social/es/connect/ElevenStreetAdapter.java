package org.springframework.social.es.connect;

import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.es.api.ElevenStreet;
import org.springframework.social.es.api.Member;

/**
 * @author HyungTae Lim
 * @since 2016. 11. 1.
 */
public class ElevenStreetAdapter implements ApiAdapter<ElevenStreet> {

    @Override
    public boolean test(ElevenStreet elevenStreet) {
        try {
            elevenStreet.getMember();
            return true;
        } catch (ApiException e) {
            return false;
        }
    }

    @Override
    public void setConnectionValues(ElevenStreet elevenStreet, ConnectionValues values) {
        final Member member = elevenStreet.getMember();
        values.setProviderUserId(member.getInformation().getMemId());
        values.setDisplayName(member.getCi().getName());
        values.setProfileUrl("");
        values.setImageUrl("");
    }

    @Override
    public UserProfile fetchUserProfile(ElevenStreet elevenStreet) {
        final Member member = elevenStreet.getMember();
        return new UserProfileBuilder().setUsername(member.getInformation().getMemId())
                .setEmail(member.getInformation().getEmail())
                .setName(member.getCi().getName())
                .setFirstName("")
                .setLastName("").build();
    }

    @Override
    public void updateStatus(ElevenStreet elevenStreet, String message) {
        throw new UnsupportedOperationException();
    }
}