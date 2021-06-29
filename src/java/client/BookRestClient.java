/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
/**
 * Jersey REST client generated for REST resource:BookResource [bookmaster]<br>
 * USAGE:
 * <pre>
 *        BookRestClient client = new BookRestClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author abhishek jariwala
 */
public class BookRestClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "https://localhost:8181/JSFSecureApp/webresources";

     public BookRestClient(String token) {
        client = javax.ws.rs.client.ClientBuilder.newClient();
      
         client.register(new RestFilter(token));
        webTarget = client.target(BASE_URI).path("bookmaster");
        
              //  .queryParam("username", username)
               // .queryParam("password", password);
      }

  static {
        //for localhost testing only
        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
                new javax.net.ssl.HostnameVerifier() {

            public boolean verify(String hostname,
                    javax.net.ssl.SSLSession sslSession) {
                if (hostname.equals("localhost")) {
                    return true;
                }
                return false;
            }
        });
    }

//    public void putJson(Object requestEntity) throws ClientErrorException {
//        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
//    }

    public <T> T getBooks(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getBooks");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T AllUsers(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("AllUsers");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

//     public String getJson() throws ClientErrorException {
//        WebTarget resource = webTarget;
//        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
//    }
//     
    public void close() {
        client.close();
    }
    
}
