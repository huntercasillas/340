
package spellcheck;

import java.net.*;
import java.io.*;


public class URLFetcher implements FetcherInterface {

	@Override public String fetch(Object obj) throws IOException {

		if (obj.getClass() != URL.class) {
			throw new IOException("This content isn't compatible yet.");
		}

		URL url = (URL) obj;
		URLConnection connection = url.openConnection();

		StringBuffer contentBuffer = new StringBuffer();

		InputStream input = connection.getInputStream();

		try {
			int c;
			while ((c = input.read()) >= 0) {
				contentBuffer.append((char)c);
			}
		}
		finally {
			input.close();
		}
		return contentBuffer.toString();
	}
}
