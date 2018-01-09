package awt.jaxrs.security.authenticator.basic;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.Test;

import awt.jaxrs.security.AuthorizationHeader;

public class AbstractBasicAuthenticatorTest {

    @SuppressWarnings("unchecked")
    @Test
    public void testValid() {
	final AuthorizationHeader header = mock(AuthorizationHeader.class);
	final String encoded = Base64.getEncoder().encodeToString("username:password".getBytes());
	when(header.getToken()).thenReturn(encoded);

	final AbstractBasicAuthenticator authenticator = mock(AbstractBasicAuthenticator.class, CALLS_REAL_METHODS);
	authenticator.authenticate(header, Collections.emptyMap());

	verify(authenticator, times(1)).authenticate(any(String.class), any(String.class), any(Map.class));
    }
}
