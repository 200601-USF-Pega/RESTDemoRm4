package com.revature.boxes.web;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.revature.boxes.dao.BoxRepoDB;
import com.revature.boxes.dao.IBoxRepo;
import com.revature.boxes.models.Box;

@Path("/service")
public class BoxService {
	
	IBoxRepo heroRepo = new BoxRepoDB();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addHero(Box hero) {
		heroRepo.addHero(hero);
		return Response.ok().build();
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllHeroes() {
		return Response.ok((ArrayList<Box>)heroRepo.getAllHeros()).build();
	}
}
