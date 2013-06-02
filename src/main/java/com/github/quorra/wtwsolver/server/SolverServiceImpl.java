package com.github.quorra.wtwsolver.server;

import com.github.quorra.wtwsolver.client.GreetingService;
import com.github.quorra.wtwsolver.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.io.File;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class SolverServiceImpl extends RemoteServiceServlet implements
    GreetingService {

  public String[] solve(final Integer size, final String choices) throws IllegalArgumentException;
    // Verify that the input is valid.
    /* if (!FieldVerifier.isValidName(input)) {
      // If the input is not valid, throw an IllegalArgumentException back to
      // the client.
      throw new IllegalArgumentException(
          "Name must be at least 4 characters long");
    }*/

    String serverInfo = getServletContext().getServerInfo();
    String userAgent = getThreadLocalRequest().getHeader("User-Agent");

    // Escape data from the client to avoid cross-site script vulnerabilities.
    // input = escapeHtml(input);
    userAgent = escapeHtml(userAgent);

    final List<String> allPossible = getPossibleStringsFrom(choices, size);
  }

  protected List<String> getPossibleStringsFrom(final String choices, final int maxSize) {
    final Character[] choiceArr = choices.toCharArray();

    int valueLength = 0;
    StringBuffer valueBuffer = "";
    for (int i = 0; i < choiceArr.length || valueLength < maxSize; i++) {
      valueBuffer.append(choiceArr[i]); 
      valueLength = i + 1;
    }
  }

  /**
   * Escape an html string. Escaping data received from the client helps to
   * prevent cross-site script vulnerabilities.
   *
   * @param html the html string to escape
   * @return the escaped string
   */
  private String escapeHtml(String html) {
    if (html == null) {
      return null;
    }
    return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(
        ">", "&gt;");
  }
}
