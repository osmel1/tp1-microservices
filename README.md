# Microservice de Gestion des Comptes Bancaires

Ce projet est un microservice Spring Boot pour la gestion des comptes bancaires. Il expose des API RESTful ainsi qu'une interface GraphQL. Le projet utilise une base de données en mémoire H2 et inclut une documentation OpenAPI/Swagger.

## 🛠️ Prérequis

- **JDK 17** ou supérieur
- **Maven**
- **IDE** (IntelliJ IDEA)
- **Client REST** (Postman )

## Créer un projet Spring Boot avec les dépendances 

Les dépendances principales utilisées dans ce projet sont :

![1](https://github.com/user-attachments/assets/4347b3e6-0ae1-4bbc-825d-d5a813edfa8e)

### L'entité  BankAcount

![compte entity](https://github.com/user-attachments/assets/70afd801-9357-4ec1-a478-ee60b29f6cbe)

### Repository  CompteRepository
Pour fournit des méthodes CRUD standard pour l'entité Compte.
![repo](https://github.com/user-attachments/assets/84d1c3af-d40c-4bb6-9591-f64decfa2fa1)


### Tester la couche DAO
Pour tester les méthodes de la couche DAO, j'ai utilisé un CommandLineRunner qui initialise l'application en créant 10 comptes bancaires. Cela permet de vérifier le bon fonctionnement des opérations CRUD.
![test database](https://github.com/user-attachments/assets/f69497c5-acc7-4283-b6e1-ebe559606e11)

**Resultat :** 

![getdata](https://github.com/user-attachments/assets/b0dcc5ce-f932-4ffc-957d-eeebafbe0be4)

### Contrôleur REST 

Le contrôleur REST BankAccountController expose plusieurs API permettant de gérer les comptes bancaires. Il utilise le service BankService et le dépôt BankAccountRepo pour interagir avec la couche de persistance. Voici les principales fonctionnalités offertes :

![controller](https://github.com/user-attachments/assets/bdc336b5-b2ea-4e4f-9668-5b5b3f7cafd0)

- GET /api/bankAccounts : Récupère la liste de tous les comptes bancaires.
- GET /api/bankAccounts/{id} : Récupère les détails d'un compte bancaire spécifique via son identifiant.
- POST /api/bankAccounts : Crée un nouveau compte bancaire à partir des données envoyées dans la requête.
- PUT /api/bankAccounts/{id} : Met à jour un compte bancaire existant en fonction des champs spécifiés.
- DELETE /api/bankAccounts/{id} : Supprime un compte bancaire via son identifiant.

### Tester le web micro-service en utilisant un client REST :  Postman

![update](https://github.com/user-attachments/assets/38ac6120-fc64-44cc-b7c0-bbf189f6aff6)

Un exmample de test (modifier un compte ) en utilisant postman 

### Documentation Swagger
Pour ajouter la documentation Swagger, il suffit d'inclure la dépendance suivante dans le fichier ```pom.xml```
```xml
<dependency>
  <groupId>org.springdoc</groupId>
  <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
  <version>2.2.0</version>
</dependency>
```

**Resultat :**
Accédez à l'URL suivante : [http://localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html).
![swagger](https://github.com/user-attachments/assets/2e390752-66f7-4392-a2ab-811d3566f5b7)


### Spring Data Rest
Spring Data Rest expose automatiquement les API CRUD pour l'entité Compte , il faut que ajouter l'annotation ```@RepositoryRestResource```
