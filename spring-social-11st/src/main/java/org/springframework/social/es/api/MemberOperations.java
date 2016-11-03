package org.springframework.social.es.api;

/**
 * @author HyungTae Lim
 * @since 2016. 11. 1.
 */
public interface MemberOperations {
    MemberAbout.Information getMemberInformation();
    MemberAbout.Ci getMemberCi();
}
