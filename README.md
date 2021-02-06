// AUTH

METHOD: POST
REGISTER CLIENT - https://bw44-anywhere-fitness.herokuapp.com/register/client

METHOD: POST
REGISTER INSTRUCTOR - https://bw44-anywhere-fitness.herokuapp.com/register/instructor

METHOD: GET
LOGIN - https://bw44-anywhere-fitness.herokuapp.com/login

// USER

METHOD: GET
GETS ALL USERS - https://bw44-anywhere-fitness.herokuapp.com/users/users

METHOD: GET
GETS USER BY ID - https://bw44-anywhere-fitness.herokuapp.com/users/user/{userid}

METHOD: PUT
!!ALL FIELDS REQUIRED
UPDATES COMPLETE USER OBJECT - https://bw44-anywhere-fitness.herokuapp.com/users/{userid}

METHOD: PATCH
UPDATES SPECIFIC USER FIELD - https://bw44-anywhere-fitness.herokuapp.com/users/{userid}

// CLIENT

METHOD: GET
GETS ALL CLIENTS - https://bw44-anywhere-fitness.herokuapp.com/clients/clients

METHOD: GET
GETS CLIENT BY ID - https://bw44-anywhere-fitness.herokuapp.com/clients/client/{clientid}

METHOD: GET
GETS CURRENT CLIENTS CLASSES - https://bw44-anywhere-fitness.herokuapp.com/clients/client/classes

METHOD: POST
CLIENT JOINS A CLASS - https://bw44-anywhere-fitness.herokuapp.com/clients/client/fitnessclass/{fitnessclassid}

// INSTRUCTOR

METHOD: GET
GETS ALL INSTRUCTORS - https://bw44-anywhere-fitness.herokuapp.com/instructors/instructors

METHOD: GET
GETS INSTRUCTOR BY ID - https://bw44-anywhere-fitness.herokuapp.com/instructors/instructor/{instructorid}
