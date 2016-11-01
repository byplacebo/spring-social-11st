package org.springframework.social.es.config.support;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.xml.ApiHelper;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.es.api.ElevenStreet;

/**
 * @author HyungTae Lim
 * @since 2016. 11. 1.
 */
public class ElevenStreetApiHelper implements ApiHelper<ElevenStreet> {

    private final UsersConnectionRepository usersConnectionRepository;

    private final UserIdSource userIdSource;

    private ElevenStreetApiHelper(
            UsersConnectionRepository usersConnectionRepository,
            UserIdSource userIdSource) {
        this.usersConnectionRepository = usersConnectionRepository;
        this.userIdSource = userIdSource;
    }

    public ElevenStreet getApi() {
        if (logger.isDebugEnabled()) {
            logger.debug("Getting API binding instance for Eleven Street provider");
        }

        Connection<ElevenStreet> connection = usersConnectionRepository
                .createConnectionRepository(userIdSource.getUserId())
                .findPrimaryConnection(ElevenStreet.class);
        if (logger.isDebugEnabled() && connection == null) {
            logger.debug("No current connection; Returning default ElevenStreetTemplate instance.");
        }
        return connection != null ? connection.getApi() : null;
    }

    private final static Log logger = LogFactory.getLog(ElevenStreetApiHelper.class);
}
