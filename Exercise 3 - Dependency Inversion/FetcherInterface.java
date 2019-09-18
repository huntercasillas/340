package spellcheck;

import java.io.IOException;

public interface FetcherInterface {
    String fetch(Object obj) throws IOException;
}
