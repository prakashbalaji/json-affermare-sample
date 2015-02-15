package com.rest.resource;

import com.rest.model.ApplicationError;
import com.rest.model.Author;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;

import static com.rest.dao.MockDAO.*;
import static java.util.Arrays.asList;
import static java.util.Collections.EMPTY_LIST;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE;
import static javax.ws.rs.core.Response.Status.PRECONDITION_FAILED;

@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorResource {

    public AuthorResource() {
    }

    @GET
    @Path("/all.json")
    public List<Author> allAuthors() {
        return asList(FOWLER, BECK);
    }

    @GET
    @Path("/names.json")
    public List<String> allAuthorNames() {
        return asList(FOWLER.getName(), BECK.getName());
    }

    @GET
    @Path("/ids.json")
    public List<Integer> allAuthorIds() {
        return asList(FOWLER.getId(), BECK.getId());
    }

    @GET
    @Path("/empty.json")
    public List<Author> emptySet() {
        return EMPTY_LIST;
    }

    @GET
    @Path("/{authorId}.json")
    public Author authorById(@PathParam("authorId") Integer authorId) {
        return FOWLER;
    }

    @DELETE
    @Path("/{authorId}.json")
    public List<Author> deleteById() {
        return asList(BECK);
    }

    @GET
    @Path("/error.json")
    public Response errorWithDetails() {
        return Response.status(PRECONDITION_FAILED).type(APPLICATION_JSON_TYPE)
                .entity(new GenericEntity<List<ApplicationError>>(asList(MISSING_NAME, MISSING_PHONE)) {
                }).build();
    }

    @GET
    @Path("/filter.json")
    public List<Author> filteredAuthors(@QueryParam("name") String name) {
        return name.equals("Beck") ? asList(BECK) : EMPTY_LIST;
    }

    @GET
    @Path("/multi_filter.json")
    public List<Author> multiFilteredAuthors(@QueryParam("name") String name, @QueryParam("id") Integer id) {
        return id == 124 && name.equals("Beck") ? asList(BECK) : EMPTY_LIST;
    }

    @GET
    @Path("/with_phone.json")
    public List<Author> authorsWithPhone() {
        return asList(FOWLER, BECK_WITH_PHONE);
    }


    @PUT
    @Path("/put_no_data.json")
    public List<Author> putNoData() {
        return asList(BECK, FOWLER);
    }

    @PUT
    @Path("/put.json")
    public List<Author> put(Author author) {
        return asList(BECK, author);
    }

    @PUT
    @Path("/put_with_headers.json")
    public List<Author> putWithHeader(Author author,@HeaderParam("client-id") String clientTokenId,@HeaderParam("client-name") String clientTokenName) {
        if(Objects.equals(clientTokenId, "1") && Objects.equals(clientTokenName, "martin")){
            return asList(author);
        }
        return EMPTY_LIST;
    }


    @POST
    @Path("/post_no_data.json")
    public List<Author> postNoData() {
        return asList(BECK, FOWLER);
    }

    @POST
    @Path("/post.json")
    public List<Author> post(Author author) {
        return asList(author);
    }

    @POST
    @Path("/post_with_headers.json")
    public List<Author> postWithHeader(Author author,@HeaderParam("client-id") String clientTokenId,@HeaderParam("client-name") String clientTokenName) {
        if(Objects.equals(clientTokenId, "1") && Objects.equals(clientTokenName, "martin")){
            return asList(author);
        }
        return EMPTY_LIST;
    }

}