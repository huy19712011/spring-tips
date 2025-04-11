# Tasket: A demo application for mutation testing

This is a headless Spring Boot application demonstrating the basic usage of PITest, a library for mutation testing.
The application uses in-memory H2 database that gets populated with sample data when you run the application.

To generate PITest reports, run the following command:

```bash
./mvnw test-compile org.pitest:pitest-maven:mutationCoverage
```

The reports will be in the `target` directory under `pit-reports`.