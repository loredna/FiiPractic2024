package ro.fiipractic.service;

public interface UserIdGenerator {

    String generateUserId(String firstName, String lastName);
}
