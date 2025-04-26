# POC of Resource Server using OAuth2 and Spring Boot

Practice for course:  
https://www.udemy.com/course/oauth2-in-spring-boot-applications

## OAuth Authorization code flow
Grant Type
1. Authorization code
2. PKCE enhanced
3. Client Credentials
4. Device Code 
5. Implicit flow
6. Password grant

```mermaid
---
config:
theme: neo-dark
title: Authorization Code Grant
---
sequenceDiagram
participant c as Client Application
participant a as Authorization Server (Keycloak)
c ->> a: GET auth code
create participant u as User
a ->> u: authenticate
destroy u
u ->> a: login
a ->> c: callback with auth code
c ->> a: POST access token
a ->> c: access and refresh token
create participant r as Resource Server (Spring Boot)
c ->> r: GET protected resource (access token)
r ->> a: validate access token
a ->> r: access token OK
r ->> c: the resource requested
```

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
