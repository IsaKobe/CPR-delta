package cz.richard.clients;

public class ClientFactory {
    public Client CreateCustomer(String firstName, String lastName){
        return new Client("abcd", firstName, lastName);
    }
}
