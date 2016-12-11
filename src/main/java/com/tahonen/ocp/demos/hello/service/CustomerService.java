package com.tahonen.ocp.demos.hello.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/customers")
public class CustomerService {
	@GET
	@Path("/")
	@Produces("application/json;charset=UTF-8")
	public Response list() {
		try {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("content", new ArrayList<String>());
			return Response.status(Response.Status.OK).entity(data).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}

	}
	@GET
	@Path("/{id}")
	@Produces("application/json;charset=UTF-8")
	public Response get(@PathParam("id") long id) {
		try {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("content", "");
			return Response.status(Response.Status.OK).entity(data).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}

	}

}