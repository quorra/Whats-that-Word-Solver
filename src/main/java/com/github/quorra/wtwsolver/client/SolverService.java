package com.github.quorra.wtwsolver.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("solve")
public interface SolverService extends RemoteService {
	String[] solve(Integer size, String choices) throws IllegalArgumentException;
}
