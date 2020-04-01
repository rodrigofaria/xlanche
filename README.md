# xlanche

### About
This is a sample project that represents a snack bar that sells lunch.

In this repository contains:
 - Back End - Java (Spring Boot)
 - Front End - Angular


### Running the project

Back End:

Open a command line inside the folder `backend/x-lanche` and execute the command:

`./mvnw spring-boot:run`

Front End:

Open a command line inside the folder `frontend/xlanche` and execute the command:

`ng serve -o`


### APIs from Back End

#GET [http://localhost:8080/xlanche/ingredients](http://localhost:8080/xlanche/ingredients)

Return the list with ingredients.

#GET [http://localhost:8080/xlanche/lunchs](http://localhost:8080/xlanche/lunchs)

Return the list with lunches.

#GET [http://localhost:8080/xlanche/promotions](http://localhost:8080/xlanche/promotions)

Return the list with promotions.

#POST [http://localhost:8080/xlanche/price](http://localhost:8080/xlanche/price)

Content-Body:
```sh
{
    "ingredients": [
        {
            "name": "Alface",
            "value": 0.4,
            "counter": 2
        },
        {
            "name": "Hambúrguer de carne",
            "value": 3.0,
            "counter": 2
        },
        {
            "name": "Queijo",
            "value": 1.5,
            "counter": 2
        }
    ],
    "price": 0.0
}
```

Execute the calc of the price to lunch passed in the content-body.