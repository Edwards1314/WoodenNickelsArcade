package com.woodennickelsarcade.ws;

import com.woodennickelsarcade.datastore.Review;
import com.woodennickelsarcade.dto.ReviewDTO;
import com.woodennickelsarcade.service.ReviewService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("")
public class ReviewWS {
    
    private static final Logger logger = Logger.getAnonymousLogger();
    @EJB
    private ReviewService reviewService;
    @Context
    private UriInfo context;

    public ReviewWS() {
    }
    @Path("review")
    @GET
    @Consumes("application/json")
    @Produces("application/json")
    public Response read() {
        try {
            List<Review> reviews = reviewService.getReviews();
            ReviewDTO[] dtos = toDTOs(reviews);
            return Response.ok(dtos).build();
        } catch (Exception e) {
            logger.log(Level.WARNING, "WS failed", e);
            return Response.serverError().build();
        }
    }
    private ReviewDTO[] toDTOs(List<Review> reviews) {
        ReviewDTO[] dtos = new ReviewDTO[reviews.size()];
        System.out.println("Review Size" + reviews.size());
        for (int i = 0; i < dtos.length; i++) {
            Review r = reviews.get(i);
            dtos[i] = new ReviewDTO(r);
        }
        return dtos;
    }
    @Path("postreview")
    @POST
    @Consumes("application/json")
    @Produces("text/plain")
    public Response create(ReviewDTO dto) {
        try {
            Review review = new Review();
            review.setCustomerName(dto.getName());
            review.setRating(dto.getRating());
            review.setReview(dto.getReview());
            reviewService.persist(review);
            return Response.ok("").build();
        } catch (Exception e) {
            logger.log(Level.WARNING, "WS failed", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Registration failed").build();
        }
    }
}
