package com.revature.boxes.web;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.revature.boxes.dao.BoxRepoDB;
import com.revature.boxes.dao.IBoxRepo;
import com.revature.boxes.models.Box;

@Path("/boxservice")
public class BoxService {

	IBoxRepo boxRepo = new BoxRepoDB();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addBox(Box box) {
		boxRepo.addBox(box);
		return Response.status(201).build();
	}

	@GET
	@Path("/allboxes")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllBoxes() {
		return Response.ok((ArrayList<Box>)boxRepo.getAllBoxes()).build();
	}

	@DELETE
	@Path("/removeBox")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response removeBox(Box box) {
		boxRepo.removeBox(box);
		return Response.status(201).build();
	}
}
