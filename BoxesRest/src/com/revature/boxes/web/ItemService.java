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

import com.revature.boxes.dao.IItemRepo;
import com.revature.boxes.dao.ItemRepoDB;
import com.revature.boxes.models.Box;
import com.revature.boxes.models.Item;

@Path("/itemservice")
public class ItemService {

	IItemRepo itemRepo = new ItemRepoDB();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addItem(Item item) {
		itemRepo.addItem(item);
		return Response.status(201).build();
	}
	
	@GET
	@Path("/allitems")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllItems() {
		return Response.ok((ArrayList<Item>)itemRepo.getAllItems()).build();
	}
	
	@DELETE
	@Path("/removeitem")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response removeItem(Item item) {
		itemRepo.deleteItem(item.getItemID());
		return Response.status(201).build();
	}
}
