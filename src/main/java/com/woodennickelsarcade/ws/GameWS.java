package com.woodennickelsarcade.ws;

import com.woodennickelsarcade.datastore.Game;
import com.woodennickelsarcade.dto.GameDTO;
import com.woodennickelsarcade.service.GameService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("")
public class GameWS {
    private static final Logger logger = Logger.getAnonymousLogger();
    @EJB
    private GameService gameService;
    @Context
    private HttpServletRequest request;

    public GameWS() {
    }
    @Path("game")
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response read( GameDTO age) {
        System.out.println("LOOOOOOOOK " + age.getAgerating() );
        try {
            List<Game> games = gameService.getGamesByAgeRating(age.getAgerating());            
            GameDTO[] dtos = toDTOs(games);
            return Response.ok(dtos).build();
        } catch (Exception e) {
            logger.log(Level.WARNING, "WS failed", e);
            return Response.serverError().build();
        }
    }
    private GameDTO[] toDTOs(List<Game> games) {
        GameDTO[] dtos = new GameDTO[games.size()];
        for (int i = 0; i < dtos.length; i++) {
            Game g = games.get(i);
            dtos[i] = new GameDTO(g);
        }
        return dtos;
    }
}
