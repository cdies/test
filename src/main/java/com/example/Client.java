/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Client {
    
    @JsonProperty("client")
    private String client;
    @JsonProperty("city")
    private String city;
    
    public Client(){
        
    }

    public Client(String client, String city) {
        this.client = client;
        this.city = city;
    }

    public String getClient() {
        return client;
    }

    public String getCity() {
        return city;
    }
    
    
    
}
