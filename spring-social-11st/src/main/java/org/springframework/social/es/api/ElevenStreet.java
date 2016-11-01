package org.springframework.social.es.api;

import org.springframework.social.ApiBinding;

/**
 * @author HyungTae Lim
 * @since 2016. 11. 1.
 */
public interface ElevenStreet extends ApiBinding {
    Member getMember();
    Ci getCi();
}
