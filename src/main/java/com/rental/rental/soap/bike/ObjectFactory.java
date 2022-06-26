
package com.rental.rental.soap.bike;

import com.rental.rental.model.Bike;
import com.rental.rental.soap.bike.delete.DeleteBikeRequest;
import com.rental.rental.soap.bike.delete.DeleteBikeResponse;
import com.rental.rental.soap.bike.edit.EditBikeRequest;
import com.rental.rental.soap.bike.edit.EditBikeResponse;
import com.rental.rental.soap.bike.get.GetBikeRequest;
import com.rental.rental.soap.bike.get.GetBikeResponse;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetBikeRequest }
     * 
     */
    public GetBikeRequest createGetBikeRequest() {
        return new GetBikeRequest();
    }

    /**
     * Create an instance of {@link GetBikeResponse }
     * 
     */
    public GetBikeResponse createGetBikeResponse() {
        return new GetBikeResponse();
    }

    /**
     * Create an instance of {@link Bike }
     * 
     */
    public Bike createBike() {
        return new Bike();
    }

    /**
     * Create an instance of {@link DeleteBikeRequest }
     * 
     */
    public DeleteBikeRequest createDeleteBikeRequest() {
        return new DeleteBikeRequest();
    }

    /**
     * Create an instance of {@link DeleteBikeResponse }
     * 
     */
    public DeleteBikeResponse createDeleteBikeResponse() {
        return new DeleteBikeResponse();
    }

    /**
     * Create an instance of {@link EditBikeRequest }
     * 
     */
    public EditBikeRequest createEditBikeRequest() {
        return new EditBikeRequest();
    }

    /**
     * Create an instance of {@link EditBikeResponse }
     * 
     */
    public EditBikeResponse createEditBikeResponse() {
        return new EditBikeResponse();
    }

}
