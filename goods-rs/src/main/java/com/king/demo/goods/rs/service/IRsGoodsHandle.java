package com.king.demo.goods.rs.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path(value = "/goodshandle")
@Produces(value = { MediaType.APPLICATION_JSON })
@Consumes(value = { MediaType.APPLICATION_JSON })
public interface IRsGoodsHandle {
  
  @GET
  @Path(value = "/queryall")
  public String queryall() throws Exception;
  
  @GET
  @Path(value="/querybyid")
  public String querybyid() throws Exception;
  
  @POST
  @Path(value ="/add")
  public String add() throws Exception;
  
  @POST
  @Path(value="/delete")
  public String delete() throws Exception;

}
