### Objective

Your assignment is to implement a productstore REST API using Java and Ecosystem Spring.

### Brief

Mike wants to build a marketplace oneline that allows him and his friends to self-publish their products and sell them. 


### Tasks

-   Implement assignment using:
    -   Language: **Java**
    -   Framework: **Ecosystem Spring( framework, springboot, data, security, mvc etc)**
-   Implement a custom user model with fields: username, pseudonym
-   Implement a product model with fields: title, description, owner (your custom user model), product_image(url) and price
    -   Choose the data type for each field that makes the most sense
-   Provide endpoints to authenticate with the API using username, password and return a JWT
-   Implement REST endpoints for the product resource
    -   get the all products ( list/detail in json )
		-	No authentication required
		-   Make the List resource searchable with query parameters ( optional, it's a bonus )
	-	publish a product
		-	authentication required
	-	update a product 
		-	authentication required
	-	unpublish a product
		-	authentication required and each user can only unpublish his own products
-   Implement API tests for all endpoints


### Evaluation Criteria

-   **Java** best practices
-   If you are using a framework make sure best practices are followed for models, configuration and tests
-   Write API tests for all implemented endpoints


### CodeSubmit

Please create your own branch with your name and push your codes in this branch.  

Test and document your code as if it were going into production



All the best and happy coding,

Solocal DSP Team.