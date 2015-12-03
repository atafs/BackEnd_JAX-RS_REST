package com.cinema.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.cinema.model.Filme;
import com.google.gson.Gson;

/**
 * REST Web Service
 * @author Americo
 */
@Path("filmes")
public class FilesResource {

    //ATTRIBUTES
    private List<Filme> filmes;

    @GET
	public String getFilmeData(@QueryParam("sortBy") String sortBy) {
    	//add to list
    	createListFilmes();
    	
    	int index = Integer.valueOf(sortBy);
		return sortBy + filmes.get(index).toString();	
    }
    
	@GET
	@Path("id/{identifier: [0-9]*}") // reg expression for only numbers
	public String getById(@PathParam("identifier") String myId) {
	 	//add to list
    	createListFilmes();
    	
    	//BAD_REQUEST
    	int index = Integer.valueOf(myId);
		if (index >= 4) {
			throw new WebApplicationException(Response
					.status(Response.Status.BAD_REQUEST)
					.header("MY EXCEPTION","MESSAGE=the LIST has only 0-3 values... choose beetwin these values")
					.build());
		}
		return "From 0-3 = " + myId + ";\n " + filmes.get(index).toString();	
	}

    /** */
    @GET
	@Path("json")
    @Produces("application/json")
    public Filme getJson() {
    	//add to list
    	createListFilmes();
        //JSON
        return filmes.get(0);
    }

    /**
     * PUT method for updating or creating an instance of FilesResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
	@Path("json")
    @Consumes("application/json")
    public void putJson(String content) {
    }
    
    /**
     * Creates new Filmes
     */
    public void createListFilmes() {
    	//LOCAL VARIABLES
        filmes = new ArrayList<>();
        
        //HARDCODED
        //ADD TRAILER
        Long trailer1Id = 0L;
        String trailer1Desc = "Star Wars: The Force Awakens is an upcoming American epic space opera[discuss] film directed, co-produced, and co-written by J. J. Abrams. The seventh installment in the main Star Wars film series, it stars Harrison Ford, Mark Hamill, Carrie Fisher, Adam Driver, Daisy Ridley, John Boyega, Oscar Isaac, Lupita Nyong'o, Andy Serkis, Domhnall Gleeson, Anthony Daniels, Peter Mayhew, and Max von Sydow. The story is set approximately 30 years after the events of Return of the Jedi (1983).\n";
        trailer1Desc += "The Force Awakens is the first film in the Star Wars sequel trilogy, announced after The Walt Disney Company's acquisition of Lucasfilm in October 2012. The film is produced by Abrams, his long-time collaborator Bryan Burk, and Lucasfilm president Kathleen Kennedy. Abrams co-wrote the film with Lawrence Kasdan, who co-wrote the original trilogy films The Empire Strikes Back (1980) and Return of the Jedi. Abrams and Kasdan rewrote an initial script by Michael Arndt. John Williams, composer and conductor of the previous six films, returns to compose the film score. Star Wars creator George Lucas served as creative consultant during the film's early production stages.\n";
        trailer1Desc += "The Force Awakens is produced by Lucasfilm and Abrams' Bad Robot Productions and will be distributed worldwide by Walt Disney Studios Motion Pictures. Filming began in April 2014 in Abu Dhabi and Iceland, with principal photography also taking place in Ireland and Pinewood Studios in England. Disney has backed the film with an extensive marketing campaign, and it is expected to break box office records with projected profits exceeding $1 billion. The Force Awakens will be released in 2D, 3D, and IMAX 3D on December 18, 2015, more than ten years following the release of the franchise's last installment, Star Wars Episode III: Revenge of the Sith (2005).";
        String trailer1Trailer = "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/sGbxmsDFVnE\" frameborder=\"0\" allowfullscreen></iframe>";
        filmes.add(new Filme(trailer1Id, "Star Wars: The Force Awakens Trailer (Official)", trailer1Trailer, trailer1Desc));
        
        //ADD TRAILER
        Long trailer2Id = 1L;
        String trailer2Title = "WARCRAFT Movie Trailer (2016)";
        String trailer2Desc = "Warcraft (no Brasil, Warcraft: O Primeiro Encontro de Dois Mundos[1] ) � um filme norte-americano de a��o fantasia �pico e de aventura, dirigido por Duncan Jones e escrito por Jones e Charles Leavitt e � distribu�do mundialmente pela Universal Pictures, assim tendo seus efeitos visuais produzidos pela Industrial Light & Magic. O filme foi anunciado pela primeira vez em 2006 com a parceria do projeto com a Legendary Pictures[2] . O filme � baseado na s�rie de jogos hom�nimos que foi produzido pela Blizzard Entertainment.\n";
        trailer2Desc += "O enredo consiste na hist�ria da origem dos encontros iniciais entre os seres humanos e os orcs , com �nfase em cima tanto a Alian�a de ambos os lados da Horda de seu conflito. Caracter�sticas que caracterizam tais como Durotan e Lothar, o filme ter� lugar em uma variedade de locais estabelecidos na s�rie de videogames.\n";
        trailer2Desc += "O elenco � composto por Ben Foster, Travis Fimmel, Paula Patton, Dominic Cooper, Toby Kebbell, Rob Kazinsky, Daniel Wu, Clancy Brown, Ben Schnetzer, Ruth Negga, Burkely Duffield, Daniel Cudmore e Callum Keith Rennie.\n";
        trailer2Desc += "O filme esta previsto para ser lan�ado no dia 10 de junho de 2016.";
        String trailer2Trailer  = "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/RhFMIRuHAL4\" frameborder=\"0\" allowfullscreen></iframe>";
        filmes.add(new Filme(trailer2Id, trailer2Title, trailer2Trailer, trailer2Desc));
        
         //ADD TRAILER
        Long trailer3Id = 2L;
        String trailer3Title = "Gods of Egypt Official Trailer #1 (2016)";
        String trailer3Desc = "Gods of Egypt is an upcoming American fantasy film featuring ancient Egyptian deities. The film is directed by Alex Proyas and stars Nikolaj Coster-Waldau, Brenton Thwaites, Gerard Butler, and Geoffrey Rush. Butler plays the god of darkness Set who takes over the Egyptian empire, and Thwaites plays the mortal hero Bek who partners with the god Horus, played by Coster-Waldau, to save the world and to rescue his love.\n";
        trailer3Desc += "Filming took place in Australia under the studio Summit Entertainment. While the film's production budget was $140 million, the parent company Lionsgate's financial exposure was less than $10 million due to tax incentives and pre-sales. When Lionsgate began promoting the film in November 2015, it received backlash for its predominantly white cast playing Egyptian characters. Lionsgate plans to release Gods of Egypt in theaters on February 26, 2016. The film will be released in 2D and RealD 3D.";
        String trailer3Trailer  = "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/IJBnK2wNQSo\" frameborder=\"0\" allowfullscreen></iframe>";
        filmes.add(new Filme(trailer3Id, trailer3Title, trailer3Trailer, trailer3Desc));
        
         //ADD TRAILER
        Long trailer4Id = 3L;
        String trailer4Title = "Captain America: Civil War Official Trailer #1 (2016)";
        String trailer4Desc = "Captain America: Civil War picks up where Avengers: Age of Ultron left off, as Steve Rogers leads the new team of Avengers in their continued efforts to safeguard humanity. After another international incident involving the Avengers results in collateral damage, political pressure mounts to install a system of accountability and a governing body to determine when to enlist the services of the team. The new status quo fractures the Avengers while they try to protect the world from a new and nefarious villain.";
        String trailer4Trailer  = "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/FkTybqcX-Yo\" frameborder=\"0\" allowfullscreen></iframe>";
        filmes.add(new Filme(trailer4Id, trailer4Title, trailer4Trailer, trailer4Desc));
    }
}