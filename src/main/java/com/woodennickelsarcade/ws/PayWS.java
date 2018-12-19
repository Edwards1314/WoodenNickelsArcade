package com.woodennickelsarcade.ws;

import com.woodennickelsarcade.datastore.Pay;
import com.woodennickelsarcade.dto.PayDTO;
import com.woodennickelsarcade.service.PayService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("")
public class PayWS {
    private static final Logger logger = Logger.getAnonymousLogger();
    @EJB
    private PayService payService;
    @Context
    private UriInfo context;

    public PayWS() {
    }
    
    @Path("getpay")
    @GET
    @Consumes("application/json")
    @Produces("application/json")
    public Response read() {
        try {
            List<Pay> reviews = payService.getPayments();
            PayDTO[] dtos = toDTOs(reviews);
            return Response.ok(dtos).build();
        } catch (Exception e) {
            logger.log(Level.WARNING, "WS failed", e);
            return Response.serverError().build();
        }
    }
    private PayDTO[] toDTOs(List<Pay> reviews) {
        PayDTO[] dtos = new PayDTO[reviews.size()];
        for (int i = 0; i < dtos.length; i++) {
            Pay r = reviews.get(i);
            dtos[i] = new PayDTO(r);
        }
        return dtos;
    }
    @Path("putpay")
    @PUT
    @Consumes("application/json")
    @Produces("text/plain")
    public Response update(PayDTO dto) {
        try {
            if (dto.getCardtype() == null 
                    || dto.getName() == null 
                    || dto.getCardnumber() == null
                    || dto.getAmount() == null) {
                return Response.status(Status.BAD_REQUEST).entity("Bad request").build();
            }
            Pay pay = new Pay();
            pay.setAmount(dto.getAmount());
            pay.setName(dto.getName());
            pay.setCardtype(dto.getCardtype());
            pay.setCardnumber(dto.getCardnumber());
            payService.persist(pay);
            return Response.ok("").build();
        } catch (Exception e) {
            logger.log(Level.WARNING, "WS failed", e);
            return Response.serverError().build();
        }
    }
    
}
