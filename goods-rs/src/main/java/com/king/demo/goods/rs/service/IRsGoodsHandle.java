package com.king.demo.goods.rs.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.king.demo.goods.rs.parameter.RsGoods;

@Path(value = "/goodshandle")
@Produces(value = {
  MediaType.APPLICATION_JSON })
@Consumes(value = {
  MediaType.APPLICATION_JSON })
public interface IRsGoodsHandle {

  @GET
  @Path(value = "/queryall")
  public String queryall() throws Exception;

  @GET
  @Path(value = "/querybyid/{id}")
  public String querybyid(@PathParam("id") String id) throws Exception;

  @POST
  @Path(value = "/add")
  public String add(RsGoods goods) throws Exception;

  @POST
  @Path(value = "/delete/{id}")
  public String delete(@PathParam("id") String id) throws Exception;

  @POST
  @Path(value = "/update")
  public String update(RsGoods goods) throws Exception;

}
