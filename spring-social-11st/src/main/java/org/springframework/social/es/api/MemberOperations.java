package org.springframework.social.es.api;

import java.util.Optional;

/**
 * @author HyungTae Lim
 * @since 2016. 11. 1.
 */
public interface MemberOperations {
    Optional<MemberAbout.Information> getMemberInformation();
    Optional<MemberAbout.Ci> getMemberCi();
}
