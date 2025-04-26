# POC of Resource Server using OAuth2 and Spring Boot

Practice for course:  
https://www.udemy.com/course/oauth2-in-spring-boot-applications

## Oauth Authentication code flow


## Keycloak Notes
Start Keycloak:
```shell
docker run \
    -p 8080:8080 \
    -e KC_BOOTSTRAP_ADMIN_USERNAME=admin \
    -e KC_BOOTSTRAP_ADMIN_PASSWORD=admin \
    quay.io/keycloak/keycloak:26.2.0 \
    start-dev
```
* Create client

* Create user
