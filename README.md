# On-Site_Service_ERP

Foundations of the program contained in this repository have been the basis of my final project required to pass the Coders Lab Java Developer bootcamp.

Main goal of this project is to incorporate experiences from my previous professional positions to create a program that would provide exact tools needed to deliver on-site service. Software that was in use in my earlier employers companies was often found limiting, lacking in features (while simultaneously containing unnecessary functionalities) and unresponsive. Futhermore the software was often requiring to provide data that was not utlised in the future while at the same time not gathering useful information that was much needed and should have been stored and aggregated.

Several technical assumptions were made at the begining of development:
1. Technologies to be used: Maven, Spring Boot, Spring Data, Hibernate, Lombok, JUnit, H2. App would use a MySQL database to store data.
2. Application would use JSP forms for the user to interact with the program.
3. As many principles of hexagonal architecture would be adhered to as practically feasible.
4. The MVC (model, view, controller) design pattern would be utilised.
5. The application would be of the monolithic variant.
6. For practice DTOs would be utilised instead of entity objects.

Core elements of the program are:
1. Clients - owners of the sites and units.
2. Sites - belong to clients and contain a number of units.
3. Units - belong to the clients and have a designated site.
4. Requests - main device for tracking service actions. 
5. Tasks - secondary device for tracking service actions or their elements.
6. Engineers - persons performing the service.

As for the domain assumptions they are as follows:
1. The clients can possess multiple units and sites. There may be multiple units in one site. However, a unit can be assigned to one client at one site.
2. Service actions are tracked using requests and tasks. Requests may be assignd to only one client and only one site. Tasks exist only within a given request and can be assigned to only one request.
3. Service request can have multiple units and engineers assigned to it. A request has to have a client, site and engineed assigned, however, it doesn't need to have any units assigned.
4. Task can have only one unit and one enginner assigned to it. Task doesn't need to have a unit assigned, yet it needs to have an assigned engineer.

During development of the app two crucial issues became apparent. First and foremost having extensive knowledge and insight into an issue doesn't necessarily translate to an ability to simply formulate coding tasks on the spot and creating a program with all its intricacies as you go. As need for better planning and clear formulation of tasks have become apparent a kanban board was created in the Trello tool to facilitate the development process (Can be found here: trello.com/b/qjkG6b16/on-site-service-erp).

Second issue that emerged was the rigidness of the MVC pattern as the JSP forms used as the view element were deemed too static and detrimental to user experience. To alleviate this problem a switch to a REST API and more responsive JavaScript utilizing interface was decided. Development of the program is at this stage currently.

Following the switch outlined above core functionalities of the program will be further developed. Future functionalities currently planned:
1. Proper work time tracking.
2. Site implementation.
3. Engineer implementation.
4. Basic reports implementation.
5. Admin and user roles implementation.
