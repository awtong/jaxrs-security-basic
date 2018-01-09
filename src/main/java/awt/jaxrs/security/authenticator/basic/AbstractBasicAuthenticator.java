package awt.jaxrs.security.authenticator.basic;

import java.util.Map;

import javax.ws.rs.core.SecurityContext;

import awt.jaxrs.security.AuthorizationHeader;
import awt.jaxrs.security.authenticator.Authenticator;

/**
 * Extensible class for when scheme = Basic.
 *
 * @author awt
 *
 */
public abstract class AbstractBasicAuthenticator implements Authenticator {

    @Override
    public SecurityContext authenticate(final AuthorizationHeader header, final Map<String, String[]> parameters) {
	final BasicPasswordAuthentication auth = new BasicPasswordAuthentication(header.getToken());
	return this.authenticate(auth.getUsername(), auth.getPassword(), parameters);
    }

    public abstract SecurityContext authenticate(final String username, final String password,
	    final Map<String, String[]> parameters);
}
